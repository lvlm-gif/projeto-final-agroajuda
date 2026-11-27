package com.example.agroajuda.ui.ui.features

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.agroajuda.R
import com.example.agroajuda.ui.ui.theme.GreenDark
import com.example.agroajuda.ui.ui.theme.GreenLight
import com.example.agroajuda.ui.ui.theme.GreenPrimary
import com.example.agroajuda.ui.ui.theme.WhiteWarm

@Composable
fun TelaLogin(
    onLoginClick: () -> Unit,
    onCadastroClick: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var senhaVisivel by remember { mutableStateOf(false) }
    var mensagemErro by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(WhiteWarm)
    ) {
        LoginBackground()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            // Logo AgroAjuda
            Box(
                modifier = Modifier
                    .size(90.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(Color.White)
                    .shadow(elevation = 2.dp, shape = RoundedCornerShape(24.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_agroajuda),
                    contentDescription = "Logo AgroAjuda",
                    modifier = Modifier.size(70.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Bem-vindo ao AgroAjuda!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = GreenDark,
                textAlign = TextAlign.Center
            )

            Text(
                text = "Acesse sua conta para continuar a ajudar sua produção",
                fontSize = 15.sp,
                color = Color.DarkGray,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 8.dp, start = 20.dp, end = 20.dp)
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Campos de Login
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "E-mail",
                    fontWeight = FontWeight.Medium,
                    color = GreenDark,
                    modifier = Modifier.padding(bottom = 6.dp)
                )
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it; mensagemErro = "" },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Digite seu e-mail", color = Color.Gray) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = null,
                            tint = GreenPrimary.copy(alpha = 0.6f)
                        )
                    },
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedContainerColor = Color.White,
                        focusedContainerColor = Color.White,
                        focusedBorderColor = GreenPrimary,
                        unfocusedBorderColor = Color(0xFFE0E0E0),
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Senha",
                    fontWeight = FontWeight.Medium,
                    color = GreenDark,
                    modifier = Modifier.padding(bottom = 6.dp)
                )
                OutlinedTextField(
                    value = senha,
                    onValueChange = { senha = it; mensagemErro = "" },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Digite sua senha", color = Color.Gray) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = null,
                            tint = GreenPrimary.copy(alpha = 0.6f)
                        )
                    },
                    shape = RoundedCornerShape(12.dp),
                    visualTransformation = if (senhaVisivel) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = { senhaVisivel = !senhaVisivel }) {
                            Icon(
                                imageVector = if (senhaVisivel) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                contentDescription = if (senhaVisivel) "Ocultar senha" else "Mostrar senha",
                                tint = GreenPrimary
                            )
                        }
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedContainerColor = Color.White,
                        focusedContainerColor = Color.White,
                        focusedBorderColor = GreenPrimary,
                        unfocusedBorderColor = Color(0xFFE0E0E0),
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black
                    )
                )

                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
                    Text(
                        text = "Esqueci minha senha",
                        color = GreenPrimary,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .clickable { /* Ação futura */ }
                            .padding(vertical = 8.dp)
                    )
                }
            }

            if (mensagemErro.isNotEmpty()) {
                Text(
                    text = mensagemErro,
                    color = Color.Red,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    if (email.isBlank() || senha.isBlank()) {
                        mensagemErro = "Preencha todos os campos."
                    } else {
                        onLoginClick()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = GreenPrimary)
            ) {
                Text("Entrar", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Ainda não possui uma conta? ", color = Color.Gray)
                Text(
                    text = "Cadastre-se",
                    color = GreenPrimary,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { onCadastroClick() }
                )
            }
            
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

@Composable
fun LoginBackground() {
    Canvas(modifier = Modifier
        .fillMaxWidth()
        .height(400.dp)) {
        val width = size.width
        val height = size.height
        
        val path1 = Path().apply {
            moveTo(0f, height * 0.5f)
            quadraticTo(width * 0.25f, height * 0.4f, width * 0.5f, height * 0.55f)
            quadraticTo(width * 0.75f, height * 0.7f, width, height * 0.5f)
            lineTo(width, height)
            lineTo(0f, height)
            close()
        }
        drawPath(path1, GreenLight.copy(alpha = 0.1f))
        
        val path2 = Path().apply {
            moveTo(0f, height * 0.6f)
            quadraticTo(width * 0.4f, height * 0.5f, width * 0.7f, height * 0.65f)
            quadraticTo(width * 0.9f, height * 0.75f, width, height * 0.6f)
            lineTo(width, height)
            lineTo(0f, height)
            close()
        }
        drawPath(path2, GreenLight.copy(alpha = 0.2f))
    }
}
