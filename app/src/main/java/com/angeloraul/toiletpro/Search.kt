package com.angeloraul.toiletpro

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun SearchScreen(navController: NavController) { // Añadido el parámetro navController
    var searchText by remember { mutableStateOf("") }
    var searchResults by remember { mutableStateOf(listOf<String>()) }
    val allItems = listOf("Broom", "Dustpan", "Cleaning Spray", "Mop", "Bucket")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)) // Fondo gris claro
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Encabezado con el emoji de carrito
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Emoji de carrito que es clickeable
            Text(
                text = "🛒",
                fontSize = 24.sp,
                modifier = Modifier
                    .clickable {
                        navController.navigate("cart") // Navegar a la pantalla del carrito
                    }
                    .padding(end = 8.dp)
            )

            // Buscador en la parte superior
            TextField(
                value = searchText,
                onValueChange = {
                    searchText = it
                    searchResults = allItems.filter { item ->
                        item.contains(searchText, ignoreCase = true)
                    }
                },
                label = { Text("Buscar productos") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Mostrar los resultados de la búsqueda
        if (searchResults.isNotEmpty()) {
            Text(
                "Resultados de búsqueda:",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            searchResults.forEach { result ->
                Text(
                    result,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
        } else {
            Text(
                "No se encontraron productos",
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSearchScreen() {
    val navController = rememberNavController() // Crea un NavController simulado
    SearchScreen(navController) // Pasa el NavController a SearchScreen
}

