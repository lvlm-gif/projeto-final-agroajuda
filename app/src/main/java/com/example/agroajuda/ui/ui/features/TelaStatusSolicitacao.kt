package com.example.agroajuda.ui.ui.features

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.agroajuda.ui.ui.theme.GreenDark
import com.example.agroajuda.ui.ui.theme.GreenLight
import com.example.agroajuda.ui.ui.theme.GreenPrimary
import com.example.agroajuda.ui.ui.theme.WhiteWarm
import com.example.agroajuda.ui.viewmodel.ProfissionalViewModel
import com.example.agroajuda.ui.viewmodel.SolicitacaoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaStatusSolicitacao(
    solicitacaoViewModel: SolicitacaoViewModel,
    profissionalViewModel: ProfissionalViewModel,
    onBackClick: () -> Unit,
    onHomeClick: () -> Unit
) {
    // Para esta fase visual, usaremos os dados estáticos fornecidos no prompt.
    // A integração com a lista real será feita futuramente.
    
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Detalhes da solicitação",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = GreenPrimary
                )
            )
        },
        containerColor = WhiteWarm
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Cartão do Profissional
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape)
                            .background(GreenLight.copy(alpha = 0.3f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = null,
                            tint = GreenPrimary,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                    
                    Spacer(modifier = Modifier.width(16.dp))
                    
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Juliana Santos",
                            color = GreenDark,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Text(
                            text = "Agrônoma",
                            color = Color.Gray,
                            fontSize = 14.sp
                        )
                        Text(
                            text = "Especialidade: Manejo do solo",
                            color = Color.Gray,
                            fontSize = 14.sp
                        )
                    }
                    
                    Surface(
                        color = Color(0xFFFFF9C4), // Amarelo claro
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Text(
                            text = "Pendente",
                            color = Color(0xFFFBC02D), // Dourado/Amarelo escuro
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Seção: Descrição
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Descrição da solicitação",
                    color = GreenDark,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Preciso de orientação sobre o controle de pragas na plantação de milho. As folhas estão apresentando manchas e gostaria de saber qual o melhor produto para o manejo.",
                    color = Color.DarkGray,
                    fontSize = 15.sp,
                    lineHeight = 22.sp
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Informações Complementares
            InfoRow(icon = Icons.Default.DateRange, label = "Data da solicitação", value = "20/10/2026")
            Spacer(modifier = Modifier.height(12.dp))
            InfoRow(icon = Icons.Default.Call, label = "Telefone do profissional", value = "(81) 98765-4321")

            Spacer(modifier = Modifier.height(24.dp))
            HorizontalDivider(color = Color.LightGray.copy(alpha = 0.5f))
            Spacer(modifier = Modifier.height(24.dp))

            // Seção: Andamento (Linha do Tempo)
            Text(
                text = "Andamento da solicitação",
                color = GreenDark,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.Start)
            )
            
            Spacer(modifier = Modifier.height(20.dp))
            
            TimelineItem(
                title = "Pendente",
                description = "Aguardando a confirmação do profissional.",
                status = TimelineStatus.ACTIVE,
                isLast = false
            )
            TimelineItem(
                title = "Aceita",
                description = "O profissional já aceitou a solicitação.",
                status = TimelineStatus.INACTIVE,
                isLast = false
            )
            TimelineItem(
                title = "Concluída",
                description = "O atendimento foi finalizado.",
                status = TimelineStatus.INACTIVE,
                isLast = true
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Botão de Retorno
            Button(
                onClick = onHomeClick,
                colors = ButtonDefaults.buttonColors(containerColor = GreenLight.copy(alpha = 0.5f)),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        contentDescription = null,
                        tint = GreenDark,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Voltar para a lista",
                        color = GreenDark,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}

@Composable
fun InfoRow(icon: ImageVector, label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.Gray,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(text = label, color = Color.Gray, fontSize = 12.sp)
            Text(text = value, color = GreenDark, fontWeight = FontWeight.Medium, fontSize = 14.sp)
        }
    }
}

enum class TimelineStatus { ACTIVE, INACTIVE }

@Composable
fun TimelineItem(
    title: String,
    description: String,
    status: TimelineStatus,
    isLast: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.width(32.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(16.dp)
                    .clip(CircleShape)
                    .background(if (status == TimelineStatus.ACTIVE) Color(0xFFFBC02D) else Color.LightGray)
            )
            if (!isLast) {
                Box(
                    modifier = Modifier
                        .width(2.dp)
                        .fillMaxHeight()
                        .background(Color.LightGray)
                )
            }
        }
        
        Spacer(modifier = Modifier.width(12.dp))
        
        Column(modifier = Modifier.padding(bottom = 24.dp)) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = if (status == TimelineStatus.ACTIVE) GreenDark else Color.Gray
            )
            Text(
                text = description,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}
