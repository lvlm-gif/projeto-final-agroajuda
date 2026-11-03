package com.example.agroajuda.ui.ui.features

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TelaCadastroCliente(
    onCadastroFinalizado: () -> Unit
) {
    var nome by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var descricao by remember { mutableStateOf("") }
    var mensagemErro by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = "Cadastro de Cliente", fontSize = 24.sp, color = Color.Black)
        
        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "Nome", color = Color.Black)
        OutlinedTextField(
            value = nome,
            onValueChange = { nome = it; mensagemErro = "" },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Digite seu nome") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Telefone", color = Color.Black)
        OutlinedTextField(
            value = telefone,
            onValueChange = { telefone = it; mensagemErro = "" },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Digite seu telefone") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "E-mail", color = Color.Black)
        OutlinedTextField(
            value = email,
            onValueChange = { email = it; mensagemErro = "" },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Digite seu e-mail") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Descrição", color = Color.Black)
        OutlinedTextField(
            value = descricao,
            onValueChange = { descricao = it; mensagemErro = "" },
            modifier = Modifier.fillMaxWidth().heightIn(min = 100.dp),
            placeholder = { Text("Digite uma descrição") }
        )

        Spacer(modifier = Modifier.height(24.dp))

        if (mensagemErro.isNotEmpty()) {
            Text(text = mensagemErro, color = Color.Red, modifier = Modifier.padding(bottom = 8.dp))
        }

        Button(
            onClick = {
                if (nome.isBlank() || telefone.isBlank() || email.isBlank() || descricao.isBlank()) {
                    mensagemErro = "Preencha todos os campos obrigatórios."
                } else {
                    onCadastroFinalizado()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cadastrar")
        }
    }
}
