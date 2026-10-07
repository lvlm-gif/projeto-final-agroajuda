
package com.example.agroajuda.ui.ui.features

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TelaDetalhes(
onSolicitarClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Detalhes do profissional",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text("Nome: Ana Souza")
        Text("Tipo: Agrônoma")
        Text("Especialidade: Agricultura familiar")
        Text("Telefone: (00) 00000-0000")

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onSolicitarClick,
            modifier = Modifier.fillMaxWidth()
        )
         {
            Text("Solicitar assistência")
        }
    }
}