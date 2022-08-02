package com.mendozacreations.listahermano

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.mendozacreations.listahermano.model.HermanoViewModel

@Composable
fun ListaHermanoScreen(
    navHostController: NavHostController,
    viewModel: HermanoViewModel = hiltViewModel()
) {
    val ScaffoldState = rememberScaffoldState()
    Scaffold(
        topBar ={
            TopAppBar(title = { Text( "AppList",
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Black
            ) })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navHostController.navigate("RegistroHermanoScreen")
                },
                backgroundColor = MaterialTheme.colors.secondary
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Hermano")
            }
        },
        scaffoldState = ScaffoldState
    ){it

        val state = viewModel.state.value

        Column(modifier = Modifier.fillMaxSize()) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.hermanos) { hermanos ->
                    HermanoItem(hermano = hermanos, {})
                }
            }

            if (state.isLoading)
                CircularProgressIndicator()
        }
    }
}
