package com.example.agroajuda.ui.ui.features

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.agroajuda.ui.ui.theme.GreenDark
import com.example.agroajuda.ui.ui.theme.GreenPrimary

@Composable
fun TelaLogin(
    onLoginClick: () -> Unit,
    onCadastroClick: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Identificação do App
        Text(
            text = "AgroAjuda",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = GreenDark
        )
        
        Text(
            text = "Bem-vindo de volta",
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Campo de E-mail
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("E-mail") },
            placeholder = { Text("seu@email.com") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de Senha
        OutlinedTextField(
            value = senha,
            onValueChange = { senha = it },
            label = { Text("Senha") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Botão Entrar
        Button(
            onClick = onLoginClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = GreenPrimary)
        ) {
            Text("Entrar", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Opção para cadastro
        TextButton(onClick = onCadastroClick) {
            Text(
                text = "Não tem uma conta? Cadastre-se",
                color = GreenDark
            )
        }
    }
}
