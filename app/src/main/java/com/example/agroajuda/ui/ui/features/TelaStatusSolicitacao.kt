package com.example.agroajuda.ui.ui.features

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.agroajuda.model.Solicitacao
import com.example.agroajuda.ui.viewmodel.ProfissionalViewModel
import com.example.agroajuda.ui.viewmodel.SolicitacaoViewModel

@Composable
fun TelaStatusSolicitacao(
    solicitacaoViewModel: SolicitacaoViewModel,
    profissionalViewModel: ProfissionalViewModel,
    onBackClick: () -> Unit,
    onHomeClick: () -> Unit
) {
    val listaSolicitacoes by solicitacaoViewModel.allSolicitacoes.collectAsState()
    var solicitacaoSelecionada by remember { mutableStateOf<Solicitacao?>(null) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        // Cabeçalho básico e funcional
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(onClick = {
                if (solicitacaoSelecionada != null) solicitacaoSelecionada = null else onBackClick()
            }) {
                Text("Voltar")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = if (solicitacaoSelecionada == null) "Solicitações" else "Detalhes",
                style = MaterialTheme.typography.headlineSmall
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (solicitacaoSelecionada == null) {
            // LISTAGEM REAL
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(listaSolicitacoes) { item ->
                    val profissional by profissionalViewModel.getProfissionalById(item.profissionalId).collectAsState(initial = null)
                    
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { solicitacaoSelecionada = item }
                            .padding(vertical = 8.dp)
                    ) {
                        Text("Identificador: #${item.id}")
                        Text("Profissional: ${profissional?.nome ?: "Carregando..."}")
                        Text("Data: ${item.data}")
                        Text("Status: ${item.status}")
                    }
                    HorizontalDivider()
                }
            }
        } else {
            // DETALHES BÁSICOS
            val sel = solicitacaoSelecionada!!
            val profissional by profissionalViewModel.getProfissionalById(sel.profissionalId).collectAsState(initial = null)
            
            // Lógica de etapa baseada no status
            val etapaAtual = when (sel.status) {
                "Aguardando resposta" -> 2
                "Aceita" -> 3
                "Concluída" -> 4
                else -> 1
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
            ) {
                Text("ID: #${sel.id}")
                Text("Profissional solicitado: ${profissional?.nome ?: "Carregando..."}")
                Text("Serviço: ${profissional?.tipo ?: "Assistência Técnica"}")
                Text("Data da solicitação: ${sel.data}")
                Text("Situação atual: ${sel.status}")

                Spacer(modifier = Modifier.height(24.dp))
                
                Text("Etapas do processo:", style = MaterialTheme.typography.titleMedium)
                Text("- 1. Solicitação enviada: OK")
                Text("- 2. Aguardando resposta: " + if (etapaAtual == 2) "[ATUAL]" else if (etapaAtual > 2) "OK" else "Pendente")
                Text("- 3. Solicitação aceita: " + if (etapaAtual == 3) "[ATUAL]" else if (etapaAtual > 3) "OK" else "Pendente")
                Text("- 4. Atendimento concluído: " + if (etapaAtual == 4) "[ATUAL]" else "Pendente")

                Spacer(modifier = Modifier.height(32.dp))

                if (etapaAtual < 4) {
                    Button(
                        onClick = {
                            val nextStatus = when (etapaAtual) {
                                2 -> "Aceita"
                                3 -> "Concluída"
                                else -> sel.status
                            }
                            solicitacaoViewModel.updateStatus(sel.id, nextStatus)
                            solicitacaoSelecionada = sel.copy(status = nextStatus)
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(if (etapaAtual == 2) "Simular Aceite" else "Simular Conclusão")
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
                
                Button(onClick = onHomeClick, modifier = Modifier.fillMaxWidth()) {
                    Text("Retornar à Tela Inicial")
                }
            }
        }
    }
}
