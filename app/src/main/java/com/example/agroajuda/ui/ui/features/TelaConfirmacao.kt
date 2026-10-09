package com.example.agroajuda.ui.ui.features

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.agroajuda.ui.ui.theme.GreenDark
import com.example.agroajuda.ui.ui.theme.GreenLight
import com.example.agroajuda.ui.ui.theme.GreenPrimary
import com.example.agroajuda.ui.ui.theme.WhiteWarm

@Composable
fun TelaConfirmacao(
    onBackClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(WhiteWarm)
    ) {
        // Ilustração Rural na base (Paisagem suave)
        RuralLandscape(modifier = Modifier.align(Alignment.BottomCenter))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Ícone de Sucesso
            Surface(
                modifier = Modifier.size(100.dp),
                shape = CircleShape,
                color = GreenPrimary.copy(alpha = 0.1f)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Sucesso",
                        modifier = Modifier.size(56.dp),
                        tint = GreenPrimary
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Mensagem Principal
            Text(
                text = "Solicitação enviada!",
                color = GreenDark,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 28.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Mensagem Complementar
            Text(
                text = "O profissional recebeu seu pedido e\nentrará em contato em breve.",
                color = Color.DarkGray,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 20.dp)
            )

            Spacer(modifier = Modifier.height(48.dp))

            // Botão de Retorno
            Button(
                onClick = onBackClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
                    .padding(horizontal = 24.dp),
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
            
            // Espaço para a paisagem não ser coberta
            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}

@Composable
fun RuralLandscape(modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(180.dp)
    ) {
        val width = size.width
        val height = size.height

        // Colinas decorativas suaves (seguindo o estilo da Tela Principal)
        val path1 = Path().apply {
            moveTo(0f, height)
            quadraticTo(width * 0.3f, height * 0.4f, width * 0.6f, height * 0.7f)
            quadraticTo(width * 0.8f, height * 0.9f, width, height * 0.6f)
            lineTo(width, height)
            close()
        }
        drawPath(path1, color = GreenLight.copy(alpha = 0.2f))

        val path2 = Path().apply {
            moveTo(0f, height)
            quadraticTo(width * 0.2f, height * 0.8f, width * 0.5f, height * 0.6f)
            quadraticTo(width * 0.8f, height * 0.4f, width, height * 0.85f)
            lineTo(width, height)
            close()
        }
        drawPath(path2, color = GreenLight.copy(alpha = 0.3f))
    }
}
