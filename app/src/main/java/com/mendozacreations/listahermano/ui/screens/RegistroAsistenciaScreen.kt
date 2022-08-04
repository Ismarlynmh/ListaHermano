package com.mendozacreations.listahermano.ui.screens

import android.app.DatePickerDialog
import android.widget.DatePicker
import android.content.Context
import androidx.activity.ComponentActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.SystemUpdate
import androidx.compose.material.icons.filled.Work
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.mendozacreations.listahermano.model.AsistenciaViewModel
import java.util.*

@Composable
fun RegistroAsistenciaScreen (navHostController: NavHostController, asistenciaViewModel:
AsistenciaViewModel = hiltViewModel() ) {

    val ScaffoldState = rememberScaffoldState()
    //var fecha by rememberSaveable { mutableStateOf("") }
    val year: Int
    val month: Int
    val day: Int

    val calendar = Calendar.getInstance()
    year = calendar.get(Calendar.YEAR)
    month = calendar.get(Calendar.MONTH)
    day = calendar.get(Calendar.DAY_OF_MONTH)

    val datePickerDialog = DatePickerDialog(
        LocalContext.current,
        {_: DatePicker, year:Int, month:Int, day:Int->
            asistenciaViewModel.fecha = "$day/$month/$year"
        },year,month,day
    )

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Edit Assistance",
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Black) },

                navigationIcon = {
                    IconButton(onClick = {
                        navHostController.navigate(
                            "AsistenciaListScreen"
                        )
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "LIST",
                            //modifier = Modifier.size(30.dp)
                        )
                    }
                }
            )
        },
        scaffoldState = ScaffoldState)
    {it
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            OutlinedTextField(
                leadingIcon = { Icon(imageVector = Icons.Default.Work, contentDescription = null) },
                value = asistenciaViewModel.presente,
                onValueChange = { asistenciaViewModel.presente = it },
                label = { Text(text = "Presents:") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                leadingIcon = { Icon(imageVector = Icons.Default.Work, contentDescription = null) },
                value = asistenciaViewModel.ausente,
                onValueChange = { asistenciaViewModel.ausente = it },
                label = { Text(text = "Absents:") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                leadingIcon = { Icon(imageVector = Icons.Filled.DateRange,
                    contentDescription = null, modifier =
                    Modifier
                        .size(40.dp)
                        .padding(4.dp)
                        .clickable { datePickerDialog.show() }) },
                value = asistenciaViewModel.fecha,
                onValueChange = { asistenciaViewModel.fecha = it },
                label = { Text(text = "Select Date:") },
                modifier = Modifier.fillMaxWidth()
            )



            Button(
                onClick = {
                    asistenciaViewModel.guardar()
                    navHostController.navigate("AsistenciaListScreen") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)) {
                Text(text = "SAVE",
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Black,)
            }
        }
    }
}