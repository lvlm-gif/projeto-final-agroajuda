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
import androidx.compose.ui.unit.sp

// Modelo local para dados fictícios
data class SolicitacaoFicticia(
    val id: String,
    val profissional: String,
    val atendimento: String,
    val data: String,
    val status: String,
    val etapaAtual: Int // 1 a 4
)

@Composable
fun TelaStatusSolicitacao(
    onBackClick: () -> Unit,
    onHomeClick: () -> Unit
) {
    // Dados fictícios para visualização funcional
    val listaSolicitacoes = remember {
        listOf(
            SolicitacaoFicticia("#2026-0042", "Ana Souza", "Cultivo de Grãos", "19/10/2026", "Aguardando resposta", 2),
            SolicitacaoFicticia("#2026-0038", "Carlos Lima", "Irrigação", "15/10/2026", "Aceita", 3),
            SolicitacaoFicticia("#2026-0021", "Mariana Alves", "Controle de Pragas", "10/10/2026", "Concluída", 4)
        )
    }

    var solicitacaoSelecionada by remember { mutableStateOf<SolicitacaoFicticia?>(null) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        // Título e Botão Voltar simples
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Button(onClick = {
                if (solicitacaoSelecionada != null) solicitacaoSelecionada = null else onBackClick()
            }) {
                Text("Voltar")
            }
            Text(
                text = if (solicitacaoSelecionada == null) "Solicitações" else "Detalhes da Solicitação",
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.width(50.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (solicitacaoSelecionada == null) {
            // LISTAGEM CRUA
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(listaSolicitacoes) { item ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { solicitacaoSelecionada = item }
                            .padding(8.dp)
                    ) {
                        Text("ID: ${item.id}")
                        Text("Profissional: ${item.profissional}")
                        Text("Data: ${item.data}")
                        Text("Status: ${item.status}")
                    }
                    HorizontalDivider()
                }
            }
        } else {
            // DETALHES BÁSICOS
            val sel = solicitacaoSelecionada!!
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
            ) {
                Text("ID: ${sel.id}")
                Text("Profissional: ${sel.profissional}")
                Text("Serviço: ${sel.atendimento}")
                Text("Data: ${sel.data}")
                Text("Status atual: ${sel.status}")

                Spacer(modifier = Modifier.height(20.dp))
                
                Text("Andamento:")
                Text("- 1. Pedido enviado: OK")
                Text("- 2. Analisando: " + if (sel.etapaAtual == 2) "[ATUAL]" else if (sel.etapaAtual > 2) "OK" else "...")
                Text("- 3. Aceito: " + if (sel.etapaAtual == 3) "[ATUAL]" else if (sel.etapaAtual > 3) "OK" else "...")
                Text("- 4. Finalizado: " + if (sel.etapaAtual == 4) "[ATUAL]" else "...")

                Spacer(modifier = Modifier.height(30.dp))
                
                Button(onClick = onHomeClick, modifier = Modifier.fillMaxWidth()) {
                    Text("Ir para Início")
                }
            }
        }
    }
}
