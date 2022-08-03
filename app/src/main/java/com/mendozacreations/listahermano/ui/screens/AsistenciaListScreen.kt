package com.mendozacreations.listahermano.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.mendozacreations.listahermano.data.dto.Asistencia
import com.mendozacreations.listahermano.model.AsistenciaViewModel

@Composable
fun AsistenciaListScreen (navHostController: NavHostController, viewModel:
AsistenciaViewModel = hiltViewModel()){

    val ScaffoldState = rememberScaffoldState()

    Scaffold(
    topBar ={
        TopAppBar(title = { Text(text = "LIST PEOPLE")},
                navigationIcon = {
                IconButton(onClick = {
                navHostController.navigate(
                    "ListaHermanoScreen"
                )
            }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "LIST",
                )
            }
        }
        )
    },
    floatingActionButton = {
        FloatingActionButton(
            onClick = {
                navHostController.navigate("RegistroAsistenciaScreen")
            },
            backgroundColor = MaterialTheme.colors.primary
        ) {
            Icon(imageVector = Icons.Default.Create, contentDescription = "Crear")
        }
    },
    scaffoldState = ScaffoldState
    ){it
        Column(modifier = Modifier.padding(8.dp)) {

            val ListAsistencia = viewModel.asistencia.collectAsState(initial = emptyList())

            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(ListAsistencia.value) { asistencia ->
                    Card(
                        shape = RoundedCornerShape(2.dp),
                        elevation = 2.dp,
                        modifier = Modifier
                            .padding(horizontal = 2.dp, vertical = 2.dp)
                            .fillMaxWidth()
                    ){
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .padding(5.dp)) {
                        Text("Presents: ${asistencia.presente}\t\t\t", color = Color.Gray, fontFamily = FontFamily.Default,
                            fontWeight = FontWeight.Normal,
                            fontStyle = FontStyle.Normal,
                            textAlign = TextAlign.End)

                        Text("Absents: ${asistencia.ausente}\t\t", color = Color.Gray, fontFamily = FontFamily.Default,
                            fontWeight = FontWeight.Normal,
                            fontStyle = FontStyle.Normal,
                            textAlign = TextAlign.End)
                        Text("Date: ${asistencia.fecha}", color = Color.Gray, fontFamily = FontFamily.Default,
                            fontWeight = FontWeight.Normal,
                            fontStyle = FontStyle.Normal,
                            textAlign = TextAlign.End)
                    }
                    }
                }
            }
        }
    }
}