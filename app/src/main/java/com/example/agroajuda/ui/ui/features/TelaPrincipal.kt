package com.example.agroajuda.ui.ui.features

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.agroajuda.R
import com.example.agroajuda.model.Profissional
import com.example.agroajuda.ui.ui.theme.GreenDark
import com.example.agroajuda.ui.ui.theme.GreenLight
import com.example.agroajuda.ui.ui.theme.GreenPrimary
import com.example.agroajuda.ui.ui.theme.WhiteWarm

@Composable
fun TelaPrincipal(
    onCadastrarClick: () -> Unit,
    onProfissionalClick: () -> Unit
) {
    // Lista de profissionais contendo exatamente três cartões conforme o prompt
    val profissionais = listOf(
        Profissional(1, "Ana Souza", "Agrônoma", "Cultivo de Grãos", "81999999999"),
        Profissional(2, "Carlos Lima", "Técnico Agrícola", "Irrigação", "81888888888"),
        Profissional(3, "Mariana Alves", "Agrônoma", "Controle de Pragas", "81777777777")
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(WhiteWarm)
    ) {
        // Paisagem agrícola: colinas e folhagens suaves (tons claros #B9D1A8)
        LandscapeBackground()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(60.dp))

            // Logo: símbolo de folhas verdes centralizado
            Box(
                modifier = Modifier
                    .size(90.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(Color.White)
                    .shadow(elevation = 2.dp, shape = RoundedCornerShape(24.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "Logo AgroAjuda",
                    modifier = Modifier.size(70.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Nome AgroAjuda: "Agro" (#183D27) e "Ajuda" (#397D45)
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = GreenDark, fontWeight = FontWeight.Bold)) {
                        append("Agro")
                    }
                    withStyle(style = SpanStyle(color = GreenPrimary, fontWeight = FontWeight.Bold)) {
                        append("Ajuda")
                    }
                },
                fontSize = 36.sp,
                letterSpacing = (-1).sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Descrição: centralizada e dividida em duas linhas
            Text(
                text = "Assistência técnica para\najudar sua produção",
                textAlign = TextAlign.Center,
                color = Color.DarkGray,
                fontSize = 17.sp,
                lineHeight = 24.sp,
                modifier = Modifier.padding(horizontal = 40.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Botão Cadastrar: centralizado, verde (#397D45), altura 48dp
            Button(
                onClick = onCadastrarClick,
                colors = ButtonDefaults.buttonColors(containerColor = GreenPrimary),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .height(48.dp)
                    .widthIn(min = 200.dp)
            ) {
                Text(
                    text = "Cadastrar",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            // Espaçamento para visualização da paisagem
            Spacer(modifier = Modifier.height(100.dp))

            // Seção de profissionais: Painel branco com cantos superiores arredondados
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color.White,
                shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                shadowElevation = 16.dp
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 24.dp, vertical = 32.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Profissionais disponíveis",
                        color = GreenDark,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    // Três cartões empilhados verticalmente
                    profissionais.forEach { profissional ->
                        ItemProfissional(profissional, onProfissionalClick)
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun LandscapeBackground() {
    Canvas(modifier = Modifier
        .fillMaxWidth()
        .height(500.dp)) {
        val width = size.width
        val height = size.height
        
        // Colinas decorativas suaves em tons claros (#B9D1A8)
        val path1 = Path().apply {
            moveTo(0f, height * 0.7f)
            quadraticBezierTo(width * 0.25f, height * 0.6f, width * 0.5f, height * 0.75f)
            quadraticBezierTo(width * 0.75f, height * 0.9f, width, height * 0.7f)
            lineTo(width, height)
            lineTo(0f, height)
            close()
        }
        drawPath(path1, GreenLight.copy(alpha = 0.2f))
        
        val path2 = Path().apply {
            moveTo(0f, height * 0.8f)
            quadraticBezierTo(width * 0.4f, height * 0.7f, width * 0.7f, height * 0.85f)
            quadraticBezierTo(width * 0.9f, height * 0.95f, width, height * 0.8f)
            lineTo(width, height)
            lineTo(0f, height)
            close()
        }
        drawPath(path2, GreenLight.copy(alpha = 0.4f))
        
        // Folhagens decorativas sutis
        fun drawLeaf(x: Float, y: Float, scale: Float) {
            val leafPath = Path().apply {
                moveTo(x, y)
                quadraticBezierTo(x + 15 * scale, y - 30 * scale, x + 30 * scale, y)
                quadraticBezierTo(x + 15 * scale, y + 30 * scale, x, y)
                close()
            }
            drawPath(leafPath, GreenLight.copy(alpha = 0.3f))
        }
        
        drawLeaf(width * 0.15f, height * 0.68f, 1.2f)
        drawLeaf(width * 0.85f, height * 0.75f, 1.5f)
        drawLeaf(width * 0.55f, height * 0.82f, 1.0f)
    }
}

@Composable
fun ItemProfissional(profissional: Profissional, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .shadow(elevation = 2.dp, shape = RoundedCornerShape(16.dp)),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Foto quadrada com cantos arredondados à esquerda
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(GreenLight.copy(alpha = 0.2f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = null,
                    tint = GreenPrimary,
                    modifier = Modifier.size(36.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = profissional.nome,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = GreenDark
                )
                Text(
                    text = profissional.tipo,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }

            // Seta à direita
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null,
                tint = Color.LightGray,
                modifier = Modifier.size(28.dp)
            )
        }
    }
}
