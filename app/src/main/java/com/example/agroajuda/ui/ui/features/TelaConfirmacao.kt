
package com.example.agroajuda.ui.ui.features

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TelaConfirmacao() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Solicitação enviada!",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Sua solicitação de assistência técnica foi registrada."
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "O profissional poderá entrar em contato para combinar o atendimento."
        )
    }
}