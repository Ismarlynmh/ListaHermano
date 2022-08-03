package com.mendozacreations.listahermano

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.EditNote
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.mendozacreations.listahermano.data.dto.HermanoDto
import com.mendozacreations.listahermano.model.HermanoViewModel
import com.mendozacreations.listahermano.ui.theme.ListaHermanoTheme

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
            ) },

                    actions = {
                IconButton(onClick = { navHostController.navigate("AsistenciaListScreen")

                }) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "EDITAR",
                        modifier = Modifier.size(30.dp)
                    )

                }
            },

        )

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

}/*
@Preview
@Composable
private fun  PreviewHermList(){
    ListaHermanoTheme{
        ListaHermanoScreen()
    }
}*/