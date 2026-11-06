package com.example.agroajuda.ui.ui.features

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TelaLogin(
    onLoginClick: () -> Unit,
    onCadastroClick: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var senhaVisivel by remember { mutableStateOf(false) }
    var mensagemErro by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "AgroAjuda", fontSize = 28.sp, color = Color.Black)
            
            Spacer(modifier = Modifier.height(32.dp))

            Text(text = "E-mail", color = Color.Black)
            OutlinedTextField(
                value = email,
                onValueChange = { email = it; mensagemErro = "" },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Digite seu e-mail") },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Senha", color = Color.Black)
            OutlinedTextField(
                value = senha,
                onValueChange = { senha = it; mensagemErro = "" },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Digite sua senha") },
                visualTransformation = if (senhaVisivel) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    Text(
                        text = if (senhaVisivel) "Ocultar" else "Mostrar",
                        modifier = Modifier
                            .clickable { senhaVisivel = !senhaVisivel }
                            .padding(8.dp),
                        fontSize = 12.sp,
                        color = Color.DarkGray
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                )
            )

            if (mensagemErro.isNotEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = mensagemErro, color = Color.Red, fontSize = 14.sp)
            }

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {
                    if (email.isBlank() || senha.isBlank()) {
                        mensagemErro = "Preencha todos os campos."
                    } else {
                        onLoginClick()
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.DarkGray,
                    contentColor = Color.White
                )
            ) {
                Text("Entrar")
            }

            Spacer(modifier = Modifier.height(16.dp))

            TextButton(onClick = onCadastroClick) {
                Text(text = "Não tem uma conta? Cadastre-se", color = Color.Black)
            }
        }
    }
}
