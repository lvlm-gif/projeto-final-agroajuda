package com.example.agroajuda.ui.ui.features

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.agroajuda.ui.ui.theme.GreenDark
import com.example.agroajuda.ui.ui.theme.GreenPrimary
import com.example.agroajuda.ui.ui.theme.WhiteWarm

// Modelo local para dados fictícios
data class SolicitacaoFicticia(
    val id: String,
    val profissional: String,
    val atendimento: String,
    val data: String,
    val status: String,
    val etapaAtual: Int // 1 a 4
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaStatusSolicitacao(
    onBackClick: () -> Unit,
    onHomeClick: () -> Unit
) {
    // Lista fixa de solicitações fictícias
    val listaSolicitacoes = remember {
        listOf(
            SolicitacaoFicticia("#2026-0042", "Ana Souza", "Cultivo de Grãos", "19/10/2026", "Aguardando resposta", 2),
            SolicitacaoFicticia("#2026-0038", "Carlos Lima", "Irrigação", "15/10/2026", "Aceita", 3),
            SolicitacaoFicticia("#2026-0021", "Mariana Alves", "Controle de Pragas", "10/10/2026", "Concluída", 4)
        )
    }

    // Estado para controlar qual solicitação está sendo visualizada em detalhes
    var solicitacaoSelecionada by remember { mutableStateOf<SolicitacaoFicticia?>(null) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = if (solicitacaoSelecionada == null) "Status das solicitações" else "Detalhes da solicitação",
                        fontWeight = FontWeight.Bold,
                        color = GreenDark,
                        fontSize = 20.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        if (solicitacaoSelecionada != null) {
                            solicitacaoSelecionada = null
                        } else {
                            onBackClick()
                        }
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar",
                            tint = GreenDark
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Transparent
                )
            )
        },
        containerColor = WhiteWarm
    ) { paddingValues ->
        if (solicitacaoSelecionada == null) {
            // VIEW: LISTAGEM
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(vertical = 16.dp)
            ) {
                items(listaSolicitacoes) { solicitacao ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { solicitacaoSelecionada = solicitacao },
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(text = solicitacao.id, fontWeight = FontWeight.Bold, color = GreenPrimary)
                                Text(text = solicitacao.data, color = Color.Gray, fontSize = 12.sp)
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(text = "Profissional: ${solicitacao.profissional}", fontWeight = FontWeight.Medium)
                            Text(text = "Atendimento: ${solicitacao.atendimento}", color = Color.DarkGray, fontSize = 14.sp)
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Status: ${solicitacao.status}",
                                color = if (solicitacao.status == "Concluída") GreenPrimary else GreenDark,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 14.sp
                            )
                        }
                    }
                }
            }
        } else {
            // VIEW: DETALHES (Reutilizando componentes anteriores)
            val sel = solicitacaoSelecionada!!
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 24.dp, vertical = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Text(
                            text = "Informações da Solicitação",
                            fontWeight = FontWeight.Bold,
                            color = GreenDark,
                            fontSize = 16.sp
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        InfoRow(label = "Profissional:", value = sel.profissional)
                        InfoRow(label = "Atendimento:", value = sel.atendimento)
                        InfoRow(label = "Data:", value = sel.data)
                        InfoRow(label = "ID:", value = sel.id)
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "Etapas do atendimento",
                    modifier = Modifier.align(Alignment.Start),
                    fontWeight = FontWeight.Bold,
                    color = GreenDark,
                    fontSize = 18.sp
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Timeline dinâmica baseada na etapaAtual do objeto fictício
                TimelineStep(
                    title = "Solicitação enviada",
                    subtitle = "Enviada em ${sel.data}",
                    status = if (sel.etapaAtual > 1) StepStatus.COMPLETED else StepStatus.CURRENT
                )
                TimelineStep(
                    title = "Aguardando resposta do profissional",
                    subtitle = "O técnico analisará seu pedido",
                    status = when {
                        sel.etapaAtual > 2 -> StepStatus.COMPLETED
                        sel.etapaAtual == 2 -> StepStatus.CURRENT
                        else -> StepStatus.UPCOMING
                    }
                )
                TimelineStep(
                    title = "Solicitação aceita",
                    subtitle = "Agendamento confirmado",
                    status = when {
                        sel.etapaAtual > 3 -> StepStatus.COMPLETED
                        sel.etapaAtual == 3 -> StepStatus.CURRENT
                        else -> StepStatus.UPCOMING
                    }
                )
                TimelineStep(
                    title = "Atendimento concluído",
                    subtitle = "Visita técnica realizada",
                    status = if (sel.etapaAtual == 4) StepStatus.CURRENT else StepStatus.UPCOMING,
                    isLast = true
                )

                Spacer(modifier = Modifier.height(48.dp))

                Button(
                    onClick = onHomeClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = GreenPrimary,
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text = "Voltar para o início",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Composable
fun InfoRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, color = Color.Gray, fontSize = 14.sp)
        Text(text = value, color = GreenDark, fontWeight = FontWeight.Medium, fontSize = 14.sp)
    }
}

enum class StepStatus {
    COMPLETED, CURRENT, UPCOMING
}

@Composable
fun TimelineStep(
    title: String,
    subtitle: String,
    status: StepStatus,
    isLast: Boolean = false
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.width(32.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .clip(CircleShape)
                    .background(
                        when (status) {
                            StepStatus.COMPLETED -> GreenPrimary
                            StepStatus.CURRENT -> GreenPrimary.copy(alpha = 0.2f)
                            StepStatus.UPCOMING -> Color.LightGray.copy(alpha = 0.5f)
                        }
                    ),
                contentAlignment = Alignment.Center
            ) {
                when (status) {
                    StepStatus.COMPLETED -> Icon(Icons.Default.Check, null, Modifier.size(16.dp), Color.White)
                    StepStatus.CURRENT -> Box(Modifier.size(10.dp).clip(CircleShape).background(GreenPrimary))
                    else -> {}
                }
            }
            if (!isLast) {
                Box(
                    modifier = Modifier
                        .width(2.dp)
                        .height(50.dp)
                        .background(
                            if (status == StepStatus.COMPLETED) GreenPrimary else Color.LightGray.copy(alpha = 0.5f)
                        )
                )
            }
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.padding(bottom = 24.dp)) {
            Text(
                text = title,
                fontWeight = if (status == StepStatus.CURRENT) FontWeight.Bold else FontWeight.Medium,
                color = if (status == StepStatus.UPCOMING) Color.Gray else GreenDark,
                fontSize = 16.sp
            )
            Text(
                text = subtitle,
                color = Color.Gray,
                fontSize = 14.sp
            )
        }
    }
}
