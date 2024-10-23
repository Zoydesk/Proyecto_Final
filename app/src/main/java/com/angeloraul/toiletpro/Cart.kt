package com.angeloraul.toiletpro

import androidx.compose.foundation.background
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

@Composable
fun CartScreenWithAddButton() {
    var cartItems by remember { mutableStateOf(listOf<CartItem>()) }
    var totalItems by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)) // Fondo gris claro
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween // Distribuye los elementos entre la parte superior e inferior
    ) {
        // Parte superior con el símbolo de carrito
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "🛒 Shopping Cart", // Emoji de carrito de compras
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = "$totalItems items", // Cantidad de artículos en el carrito
                fontSize = 18.sp,
                modifier = Modifier.padding(8.dp)
            )
        }

        // Botón en la parte inferior
        Button(
            onClick = {
                // Acción para añadir un item al carrito (ejemplo)
                cartItems = cartItems + CartItem("New Item", 1, 10.0)
                totalItems += 1
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text("Añadir al carrito", fontSize = 18.sp)
        }
    }
}

data class CartItem(val name: String, var quantity: Int, val price: Double)

@Preview(showBackground = true)
@Composable
fun PreviewCartScreenWithAddButton() {
    CartScreenWithAddButton()
}
