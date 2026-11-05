package com.example.agroajuda.ui.ui.features

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TelaDescricaoSolicitacao(
    onEnviarClick: (String) -> Unit
) {
    var descricao by remember { mutableStateOf("") }
    var mensagemErro by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Descreva sua solicitação",
                fontSize = 24.sp,
                color = Color.Black
            )
            
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Conte o que você precisa ou qual problema está enfrentando",
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(24.dp))

            OutlinedTextField(
                value = descricao,
                onValueChange = { 
                    descricao = it
                    mensagemErro = ""
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 150.dp),
                placeholder = { Text("Escreva aqui os detalhes...") },
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
                    if (descricao.isBlank()) {
                        mensagemErro = "A descrição é obrigatória."
                    } else {
                        onEnviarClick(descricao)
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.DarkGray,
                    contentColor = Color.White
                )
            ) {
                Text("Enviar solicitação")
            }
        }
    }
}
