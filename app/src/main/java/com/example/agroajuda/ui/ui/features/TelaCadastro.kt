package com.example.agroajuda.ui.ui.features

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaCadastro() {
    // Mantemos estados básicos apenas para permitir a interação visual na tela
    var nome by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tipo by remember { mutableStateOf("Agrônomo") }
    var especializacao by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Criar cadastro",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* Sem ação funcional conforme solicitado */ }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar",
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(24.dp)
        ) {
            
            // Campo Nome
            CustomLabel("Nome")
            CustomTextField(
                value = nome,
                onValueChange = { nome = it },
                placeholder = "Digite seu nome completo"
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Campo Telefone
            CustomLabel("Telefone")
            CustomTextField(
                value = telefone,
                onValueChange = { telefone = it },
                placeholder = "(XX) XXXXX-XXXX"
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Campo E-mail
            CustomLabel("E-mail")
            CustomTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = "seu@email.com"
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Tipo de Usuário
            CustomLabel("Tipo de usuário")
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = tipo == "Agrônomo",
                    onClick = { tipo = "Agrônomo" },
                    colors = RadioButtonDefaults.colors(selectedColor = MaterialTheme.colorScheme.primary)
                )
                Text("Agrônomo", style = MaterialTheme.typography.bodyLarge)
                
                Spacer(modifier = Modifier.width(24.dp))
                
                RadioButton(
                    selected = tipo == "Técnico Agrícola",
                    onClick = { tipo = "Técnico Agrícola" },
                    colors = RadioButtonDefaults.colors(selectedColor = MaterialTheme.colorScheme.primary)
                )
                Text("Técnico Agrícola", style = MaterialTheme.typography.bodyLarge)
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Campo Especialização
            CustomLabel("Especialização")
            CustomTextField(
                value = especializacao,
                onValueChange = { especializacao = it },
                placeholder = "Ex.: Solo e adubação"
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Botão Cadastrar
            Button(
                onClick = { /* Sem ação funcional conforme solicitado */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = Color.White
                ),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 2.dp)
            ) {
                Text(
                    text = "Cadastrar",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
            
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
fun CustomLabel(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(bottom = 8.dp),
        color = MaterialTheme.colorScheme.onBackground
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(12.dp)),
        placeholder = { 
            Text(
                text = placeholder,
                color = Color.Gray.copy(alpha = 0.5f)
            ) 
        },
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = Color.LightGray.copy(alpha = 0.6f),
            cursorColor = MaterialTheme.colorScheme.primary
        ),
        singleLine = true
    )
}
