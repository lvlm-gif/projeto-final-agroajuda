
package com.example.agroajuda.ui.ui.features

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TelaCadastro() {
    var nome by remember { mutableStateOf("") }
    var tipo by remember { mutableStateOf("Agrônomo") }
    var especialidade by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }
    var descricao by remember { mutableStateOf("") }
    var mensagem by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text(
            text = "Cadastro de profissional",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Nome completo") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text("Tipo de profissional")

        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            RadioButton(
                selected = tipo == "Agrônomo",
                onClick = { tipo = "Agrônomo" }
            )
            Text("Agrônomo")

            Spacer(modifier = Modifier.width(8.dp))

            RadioButton(
                selected = tipo == "Técnico agrícola",
                onClick = { tipo = "Técnico agrícola" }
            )
            Text("Técnico agrícola")
        }

        OutlinedTextField(
            value = especialidade,
            onValueChange = { especialidade = it },
            label = { Text("Especialidade") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = telefone,
            onValueChange = { telefone = it },
            label = { Text("Telefone") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = descricao,
            onValueChange = { descricao = it },
            label = { Text("Descrição") },
            modifier = Modifier.fillMaxWidth(),
            minLines = 3
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                mensagem = if (
                    nome.isNotBlank() &&
                    especialidade.isNotBlank() &&
                    telefone.isNotBlank()
                ) {
                    "Cadastro preenchido com sucesso!"
                } else {
                    "Preencha nome, especialidade e telefone."
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Validar cadastro")
        }

        if (mensagem.isNotEmpty()) {
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = mensagem)
        }
    }
}