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

@Composable
fun TelaConfirmacao() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDFCF9)) // Fundo levemente aquecido
    ) {
        // Ilustração Rural na base
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
                modifier = Modifier.size(120.dp),
                shape = CircleShape,
                color = MaterialTheme.colorScheme.secondaryContainer
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                        modifier = Modifier.size(64.dp),
                        tint = MaterialTheme.colorScheme.tertiary // Verde escuro
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Mensagem Principal
            Text(
                text = "Solicitação enviada com sucesso!",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    lineHeight = 32.sp
                ),
                color = MaterialTheme.colorScheme.tertiary,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Mensagem Complementar
            Text(
                text = "Em breve o profissional entrará em contato com você.",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.DarkGray,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(48.dp))

            // Botão de Retorno
            Button(
                onClick = { /* Sem ação funcional conforme solicitado */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = Color.White
                ),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 2.dp)
            ) {
                Text(
                    text = "Voltar para o início",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
            
            // Espaço para não sobrepor a paisagem em telas muito pequenas
            Spacer(modifier = Modifier.height(100.dp))
        }
    }
}

@Composable
fun RuralLandscape(modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        val width = size.width
        val height = size.height

        // Colina posterior (verde mais claro)
        val path1 = Path().apply {
            moveTo(0f, height)
            quadraticTo(width * 0.3f, height * 0.4f, width * 0.7f, height * 0.7f)
            quadraticTo(width * 0.85f, height * 0.85f, width, height * 0.6f)
            lineTo(width, height)
            close()
        }
        drawPath(path1, color = Color(0xFFC8E6C9))

        // Colina frontal (verde médio)
        val path2 = Path().apply {
            moveTo(0f, height)
            quadraticTo(width * 0.2f, height * 0.8f, width * 0.5f, height * 0.5f)
            quadraticTo(width * 0.8f, height * 0.2f, width, height * 0.9f)
            lineTo(width, height)
            close()
        }
        drawPath(path2, color = Color(0xFFA5D6A7))
    }
}
