package com.example.agroajuda.ui.ui.features

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
fun TelaCadastroCliente(
    onCadastroFinalizado: () -> Unit
) {
    var nome by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var senhaVisivel by remember { mutableStateOf(false) }
    var descricao by remember { mutableStateOf("") }
    var mensagemErro by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Cadastro de Cliente",
                fontSize = 24.sp,
                color = Color.Black
            )
            
            Spacer(modifier = Modifier.height(24.dp))

            Text(text = "Nome", color = Color.Black)
            OutlinedTextField(
                value = nome,
                onValueChange = { nome = it; mensagemErro = "" },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Digite seu nome completo") },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Telefone", color = Color.Black)
            OutlinedTextField(
                value = telefone,
                onValueChange = { telefone = it; mensagemErro = "" },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("(XX) XXXXX-XXXX") },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "E-mail", color = Color.Black)
            OutlinedTextField(
                value = email,
                onValueChange = { email = it; mensagemErro = "" },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("seu@email.com") },
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
                placeholder = { Text("Crie sua senha") },
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

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Descrição", color = Color.Black)
            OutlinedTextField(
                value = descricao,
                onValueChange = { descricao = it; mensagemErro = "" },
                modifier = Modifier.fillMaxWidth().heightIn(min = 100.dp),
                placeholder = { Text("Descreva sua necessidade") },
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
                    if (nome.isBlank() || telefone.isBlank() || email.isBlank() || senha.isBlank() || descricao.isBlank()) {
                        mensagemErro = "Preencha todos os campos obrigatórios."
                    } else {
                        onCadastroFinalizado()
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.DarkGray,
                    contentColor = Color.White
                )
            ) {
                Text("Cadastrar")
            }
        }
    }
}
