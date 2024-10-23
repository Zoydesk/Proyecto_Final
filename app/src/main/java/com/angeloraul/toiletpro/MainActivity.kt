package com.angeloraul.toiletpro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.navigation.NavController
import androidx.navigation.compose.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Configuración del gráfico de navegación
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "login") {
                composable("login") {
                    LoginScreen(
                        onLoginSuccess = {
                            navController.navigate("search")
                        },
                        onNavigateToRegister = {
                            navController.navigate("register") // Navega a la pantalla de registro
                        }
                    )
                }
                composable("register") {
                    RegisterScreen(onRegisterSuccess = {
                        navController.navigate("search") // Navega a la pantalla de búsqueda tras un registro exitoso
                    })
                }
                composable("search") { SearchScreen(navController) }
                composable("cart") { CartScreenWithAddButton() }
            }
        }
    }
}
