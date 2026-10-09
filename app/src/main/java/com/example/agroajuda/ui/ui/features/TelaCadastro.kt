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
import com.example.agroajuda.ui.ui.theme.GreenDark
import com.example.agroajuda.ui.ui.theme.GreenPrimary
import com.example.agroajuda.ui.ui.theme.WhiteWarm

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaCadastro(
    onBackClick: () -> Unit = {}
) {
    // Estados para os campos
    var nome by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tipoUsuario by remember { mutableStateOf("Agrônomo") }
    var especializacao by remember { mutableStateOf("") }
    
    // Estados para feedback (mensagens de erro ou sucesso)
    var mensagemFeedback by remember { mutableStateOf("") }
    var isErro by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Criar cadastro",
                        fontWeight = FontWeight.Bold,
                        color = GreenDark,
                        fontSize = 20.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar",
                            tint = GreenDark
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Transparent
                )
            )
        },
        containerColor = WhiteWarm
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            // Campo Nome
            CadastroLabel("Nome")
            CadastroTextField(
                value = nome,
                onValueChange = { 
                    nome = it
                    mensagemFeedback = "" // Limpa a mensagem ao digitar
                },
                placeholder = "Digite seu nome completo"
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo Telefone
            CadastroLabel("Telefone")
            CadastroTextField(
                value = telefone,
                onValueChange = { 
                    telefone = it
                    mensagemFeedback = ""
                },
                placeholder = "(XX) XXXXX-XXXX"
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo E-mail
            CadastroLabel("E-mail")
            CadastroTextField(
                value = email,
                onValueChange = { 
                    email = it
                    mensagemFeedback = ""
                },
                placeholder = "seu@email.com"
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Tipo de usuário
            CadastroLabel("Tipo de usuário")
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                RadioButton(
                    selected = tipoUsuario == "Agrônomo",
                    onClick = { tipoUsuario = "Agrônomo" },
                    colors = RadioButtonDefaults.colors(selectedColor = GreenPrimary)
                )
                Text(text = "Agrônomo", color = Color.Black, fontSize = 16.sp)

                Spacer(modifier = Modifier.width(20.dp))

                RadioButton(
                    selected = tipoUsuario == "Técnico Agrícola",
                    onClick = { tipoUsuario = "Técnico Agrícola" },
                    colors = RadioButtonDefaults.colors(selectedColor = GreenPrimary)
                )
                Text(text = "Técnico Agrícola", color = Color.Black, fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Campo Especialização
            CadastroLabel("Especialização")
            CadastroTextField(
                value = especializacao,
                onValueChange = { 
                    especializacao = it
                    mensagemFeedback = ""
                },
                placeholder = "Ex.: Solo e adubação"
            )

            Spacer(modifier = Modifier.height(24.dp))
            
            // Exibição da mensagem de feedback
            if (mensagemFeedback.isNotEmpty()) {
                Text(
                    text = mensagemFeedback,
                    color = if (isErro) Color.Red else GreenPrimary,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }

            // Botão Cadastrar
            Button(
                onClick = {
                    if (nome.isBlank() || telefone.isBlank() || email.isBlank() || especializacao.isBlank()) {
                        mensagemFeedback = "Preencha todos os campos obrigatórios."
                        isErro = true
                    } else {
                        mensagemFeedback = "Cadastro concluído!"
                        isErro = false
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = GreenPrimary,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Cadastrar",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
            
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun CadastroLabel(text: String) {
    Text(
        text = text,
        color = Color.Black,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        modifier = Modifier.padding(bottom = 8.dp)
    )
}

@Composable
fun CadastroTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(10.dp)),
        placeholder = {
            Text(text = placeholder, color = Color.Gray)
        },
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color.LightGray.copy(alpha = 0.5f),
            focusedBorderColor = GreenPrimary,
            cursorColor = GreenPrimary
        ),
        singleLine = true
    )
}
