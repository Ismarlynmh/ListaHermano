package com.mendozacreations.listahermano

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mendozacreations.listahermano.ui.theme.ListaHermanoTheme
import com.mendozacreations.listahermano.util.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListaHermanoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    MyApps()
                }
            }
        }
    }
}
@Composable
fun MyApps() {
    ListaHermanoTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val navHostController = rememberNavController()

            NavHost(navController = navHostController, startDestination = Screen.ListaHermanoScreen.route) {
                composable(route = Screen.ListaHermanoScreen.route) {
                    ListaHermanoScreen(navHostController = navHostController)
                }
                composable(route = Screen.RegistroHermanoScreen.route){
                    RegistroHermanoScreen(navHostController = navHostController)
                }
            }
        }
    }
}
