package com.angeloraul.toiletpro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit, onNavigateToRegister: () -> Unit) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE0E0E0)), // Fondo gris claro
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Imagen de ToiletPro
        Image(
            painter = painterResource(id = R.drawable.toiletpro), // Asegúrate de que la imagen esté en res/drawable
            contentDescription = "Logo ToiletPro",
            modifier = Modifier
                .size(200.dp) // Ajusta el tamaño según sea necesario
                .padding(bottom = 24.dp) // Espacio debajo de la imagen
        )

        Text(
            text = "Welcome to ToiletPro",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Campo de texto para el nombre de usuario
        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(bottom = 16.dp),
            singleLine = true
        )

        // Campo de texto para la contraseña
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(), // Siempre oculta la contraseña
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(bottom = 16.dp),
            singleLine = true
        )

        // Botón de inicio de sesión
        Button(
            onClick = { onLoginSuccess() },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(48.dp)
        ) {
            Text("LOG IN", fontSize = 16.sp)
        }

        // Enlace para ir a la pantalla de registro
        TextButton(
            onClick = { onNavigateToRegister() },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Don't have an account? Register here", color = Color.Blue)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    LoginScreen(onLoginSuccess = {}, onNavigateToRegister = {})
}
