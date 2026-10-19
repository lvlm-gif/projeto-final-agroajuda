package com.example.agroajuda.ui.ui.features

import android.content.Intent
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.agroajuda.model.Profissional
import com.example.agroajuda.ui.ui.theme.GreenDark
import com.example.agroajuda.ui.ui.theme.GreenLight
import com.example.agroajuda.ui.ui.theme.GreenPrimary
import com.example.agroajuda.ui.ui.theme.WhiteWarm
import com.example.agroajuda.ui.viewmodel.ProfissionalViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaCadastro(
    viewModel: ProfissionalViewModel,
    onBackClick: () -> Unit = {}
) {
    val context = LocalContext.current
    
    // Estados para os campos
    var nome by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tipoUsuario by remember { mutableStateOf("Agrônomo") }
    var descricaoProfissional by remember { mutableStateOf("") }
    var fotoUri by remember { mutableStateOf<Uri?>(null) }
    
    // Launcher para selecionar imagem
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia()
    ) { uri ->
        if (uri != null) {
            fotoUri = uri
            try {
                context.contentResolver.takePersistableUriPermission(
                    uri,
                    Intent.FLAG_GRANT_READ_URI_PERMISSION
                )
            } catch (e: Exception) {}
        }
    }

    // Carregar bitmap para o preview
    val bitmap = remember(fotoUri) {
        fotoUri?.let { uri ->
            try {
                if (Build.VERSION.SDK_INT < 28) {
                    @Suppress("DEPRECATION")
                    MediaStore.Images.Media.getBitmap(context.contentResolver, uri)
                } else {
                    val source = ImageDecoder.createSource(context.contentResolver, uri)
                    ImageDecoder.decodeBitmap(source)
                }
            } catch (e: Exception) { null }
        }
    }

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
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Seletor de Foto
            Box(
                modifier = Modifier
                    .size(90.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .clickable { 
                        launcher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
                    },
                contentAlignment = Alignment.Center
            ) {
                if (bitmap != null) {
                    Image(
                        bitmap = bitmap.asImageBitmap(),
                        contentDescription = "Foto selecionada",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                } else {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "Adicionar foto",
                        tint = GreenLight,
                        modifier = Modifier.size(90.dp)
                    )
                }
            }

            Text(
                text = if (fotoUri == null) "Adicionar foto" else "Alterar foto",
                color = GreenPrimary,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(top = 8.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Column(horizontalAlignment = Alignment.Start, modifier = Modifier.fillMaxWidth()) {
                CadastroLabel("Nome")
                CadastroTextField(
                    value = nome,
                    onValueChange = { nome = it; mensagemFeedback = "" },
                    placeholder = "Digite seu nome completo"
                )

                Spacer(modifier = Modifier.height(16.dp))

                CadastroLabel("Telefone")
                CadastroTextField(
                    value = telefone,
                    onValueChange = { telefone = it; mensagemFeedback = "" },
                    placeholder = "(XX) XXXXX-XXXX"
                )

                Spacer(modifier = Modifier.height(16.dp))

                CadastroLabel("E-mail")
                CadastroTextField(
                    value = email,
                    onValueChange = { email = it; mensagemFeedback = "" },
                    placeholder = "seu@email.com"
                )

                Spacer(modifier = Modifier.height(16.dp))

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

                CadastroLabel("Descrição do profissional")
                CadastroTextField(
                    value = descricaoProfissional,
                    onValueChange = { descricaoProfissional = it; mensagemFeedback = "" },
                    placeholder = "Descreva sua experiência e especialidades...",
                    singleLine = false
                )

                Spacer(modifier = Modifier.height(24.dp))
                
                if (mensagemFeedback.isNotEmpty()) {
                    Text(
                        text = mensagemFeedback,
                        color = if (isErro) Color.Red else GreenPrimary,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }

                Button(
                    onClick = {
                        if (nome.isBlank() || telefone.isBlank() || email.isBlank() || descricaoProfissional.isBlank()) {
                            mensagemFeedback = "Preencha todos os campos obrigatórios."
                            isErro = true
                        } else {
                            val novoProfissional = Profissional(
                                nome = nome,
                                telefone = telefone,
                                tipo = tipoUsuario,
                                especialidade = "",
                                descricao = descricaoProfissional,
                                fotoUri = fotoUri?.toString()
                            )
                            viewModel.insert(novoProfissional) {
                                mensagemFeedback = "Cadastro concluído!"
                                isErro = false
                                nome = ""; telefone = ""; email = ""; descricaoProfissional = ""; fotoUri = null
                            }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
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
}

@Composable
fun CadastroLabel(text: String) {
    Text(
        text = text,
        color = Color.Black,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        modifier = Modifier.padding(bottom = 4.dp)
    )
}

@Composable
fun CadastroTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    singleLine: Boolean = true
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .then(if (singleLine) Modifier.height(56.dp) else Modifier.heightIn(min = 100.dp)),
        placeholder = {
            Text(text = placeholder, color = Color.Gray, fontSize = 15.sp)
        },
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            unfocusedBorderColor = Color(0xFFE0E0E0),
            focusedBorderColor = GreenPrimary,
            cursorColor = GreenPrimary,
            unfocusedPlaceholderColor = Color.Gray,
            focusedPlaceholderColor = Color.Gray,
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.White
        ),
        singleLine = singleLine,
        textStyle = LocalTextStyle.current.copy(
            fontSize = 15.sp,
            color = Color.Black
        )
    )
}
