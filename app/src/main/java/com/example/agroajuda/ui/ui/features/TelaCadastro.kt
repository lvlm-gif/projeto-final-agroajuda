package com.example.agroajuda.ui.ui.features

import android.content.Intent
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.agroajuda.R
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
    
    var nome by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tipoUsuario by remember { mutableStateOf("Agrônomo") }
    var especialidade by remember { mutableStateOf("") }
    var descricaoProfissional by remember { mutableStateOf("") }
    var fotoUri by remember { mutableStateOf<Uri?>(null) }
    
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
            TopAppBar(
                title = { },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar",
                            tint = GreenDark
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
            )
        },
        containerColor = WhiteWarm
    ) { paddingValues ->
        Box(modifier = Modifier.fillMaxSize()) {
            LoginBackground() // Reutilizando o fundo para consistência

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Logo AgroAjuda
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.White)
                        .shadow(elevation = 2.dp, shape = RoundedCornerShape(16.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo_agroajuda),
                        contentDescription = "Logo AgroAjuda",
                        modifier = Modifier.size(45.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Crie sua conta",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = GreenDark
                )

                Text(
                    text = "O cadastro permite que você acesse todos os serviços do AgroAjuda e ajude agricultores.",
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 8.dp, horizontal = 20.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Seletor de Foto moderno
                Box(contentAlignment = Alignment.BottomEnd) {
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                            .border(2.dp, GreenPrimary.copy(alpha = 0.3f), CircleShape)
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
                                modifier = Modifier.size(100.dp)
                            )
                        }
                    }
                    
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(GreenPrimary)
                            .padding(6.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.CameraAlt,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                Column(horizontalAlignment = Alignment.Start, modifier = Modifier.fillMaxWidth()) {
                    CadastroLabel("Nome completo")
                    CadastroTextField(
                        value = nome,
                        onValueChange = { nome = it; mensagemFeedback = "" },
                        placeholder = "Ex: João Silva"
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Column(modifier = Modifier.weight(1f)) {
                            CadastroLabel("Telefone")
                            CadastroTextField(
                                value = telefone,
                                onValueChange = { telefone = it; mensagemFeedback = "" },
                                placeholder = "(00) 00000-0000"
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    CadastroLabel("E-mail")
                    CadastroTextField(
                        value = email,
                        onValueChange = { email = it; mensagemFeedback = "" },
                        placeholder = "seu@email.com"
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    CadastroLabel("Especialização")
                    CadastroTextField(
                        value = especialidade,
                        onValueChange = { especialidade = it; mensagemFeedback = "" },
                        placeholder = "Ex: Fruticultura, Irrigação..."
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    CadastroLabel("Tipo de usuário")
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        TipoUsuarioCard(
                            label = "Agrônomo",
                            isSelected = tipoUsuario == "Agrônomo",
                            onClick = { tipoUsuario = "Agrônomo" },
                            modifier = Modifier.weight(1f)
                        )
                        TipoUsuarioCard(
                            label = "Técnico",
                            isSelected = tipoUsuario == "Técnico Agrícola",
                            onClick = { tipoUsuario = "Técnico Agrícola" },
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    CadastroLabel("Descrição Profissional")
                    CadastroTextField(
                        value = descricaoProfissional,
                        onValueChange = { descricaoProfissional = it; mensagemFeedback = "" },
                        placeholder = "Conte um pouco sobre sua experiência...",
                        singleLine = false
                    )

                    Spacer(modifier = Modifier.height(32.dp))
                    
                    if (mensagemFeedback.isNotEmpty()) {
                        Text(
                            text = mensagemFeedback,
                            color = if (isErro) Color.Red else GreenPrimary,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp)
                        )
                    }

                    Button(
                        onClick = {
                            if (nome.isBlank() || telefone.isBlank() || email.isBlank() || especialidade.isBlank()) {
                                mensagemFeedback = "Preencha todos os campos obrigatórios."
                                isErro = true
                            } else {
                                val novoProfissional = Profissional(
                                    nome = nome,
                                    telefone = telefone,
                                    tipo = tipoUsuario,
                                    especialidade = especialidade,
                                    descricao = descricaoProfissional,
                                    fotoUri = fotoUri?.toString()
                                )
                                viewModel.insert(novoProfissional) {
                                    mensagemFeedback = "Cadastro concluído com sucesso!"
                                    isErro = false
                                    nome = ""; telefone = ""; email = ""; especialidade = ""; descricaoProfissional = ""; fotoUri = null
                                }
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = GreenPrimary)
                    ) {
                        Text(
                            text = "Cadastrar",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    }
                    
                    Spacer(modifier = Modifier.height(40.dp))
                }
            }
        }
    }
}

@Composable
fun TipoUsuarioCard(
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .height(48.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        color = if (isSelected) GreenPrimary else Color.White,
        border = if (isSelected) null else BorderStroke(1.dp, Color(0xFFE0E0E0)),
        shadowElevation = if (isSelected) 4.dp else 0.dp
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = label,
                color = if (isSelected) Color.White else Color.Gray,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun CadastroLabel(text: String) {
    Text(
        text = text,
        color = GreenDark,
        fontWeight = FontWeight.Bold,
        fontSize = 15.sp,
        modifier = Modifier.padding(bottom = 6.dp)
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
            .then(if (singleLine) Modifier.height(56.dp) else Modifier.heightIn(min = 120.dp)),
        placeholder = {
            Text(text = placeholder, color = Color.Gray, fontSize = 14.sp)
        },
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            unfocusedBorderColor = Color(0xFFE0E0E0),
            focusedBorderColor = GreenPrimary,
            cursorColor = GreenPrimary,
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
