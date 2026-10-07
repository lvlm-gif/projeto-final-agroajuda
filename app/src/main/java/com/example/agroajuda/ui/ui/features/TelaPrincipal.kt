
package com.example.agroajuda.ui.ui.features

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TelaPrincipal(
    onCadastrarClick: () -> Unit,
    onProfissionalClick: () -> Unit
) {
    val profissionais = listOf(
        "Ana Souza - Agrônoma",
        "Carlos Lima - Técnico agrícola",
        "Mariana Alves - Agrônoma"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "AgroAjuda",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text("Assistência técnica para sua produção rural.")

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = onCadastrarClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cadastrar profissional")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Profissionais disponíveis",
            style = MaterialTheme.typography.titleLarge
        )

        LazyColumn {
            items(profissionais) { profissional ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                        .clickable { onProfissionalClick() }
                ) {
                    Text(
                        text = profissional,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}