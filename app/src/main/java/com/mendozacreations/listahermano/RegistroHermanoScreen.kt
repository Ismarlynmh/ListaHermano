package com.mendozacreations.listahermano

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun RegistroHermanoScreen (
    navHostController: NavHostController,
    viewModel: HermanoViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()

    var validar = LocalContext.current
    val focusRequesterDescripcion = FocusRequester()
    val focusRequesterValor = FocusRequester()
    val focusRequesterTelefono = FocusRequester()

    var error by remember {
        mutableStateOf(false)

    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "NEW ITEM",
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.Black,
                        fontStyle = FontStyle.Normal
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navHostController.navigate(
                            "ListaHermanoScreen"
                        )
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "CONSULTA",
                            //modifier = Modifier.size(30.dp)
                        )
                    }
                }
            )
        },
        scaffoldState = scaffoldState
    ) {
        Column(
            Modifier
                .padding(it)
                .padding(16.dp)
        ) {

            OutlinedTextField(
                value = viewModel.descripcion,
                label = {
                    Text(
                        text = "Name",
                        fontStyle = FontStyle.Normal
                    )
                },
                onValueChange = {
                    viewModel.descripcion = it
                    error = false
                },
                isError = error,
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequesterDescripcion),

                )

            val assistiveElementText = if (error)
                "Error: Obligatorio" else "*Obligatorio"
            val assistiveElementColor = if (error) {
                MaterialTheme.colors.error
            } else {
                MaterialTheme.colors
                    .onSurface
                    .copy(alpha = ContentAlpha.medium)
            }

            Text(
                text = assistiveElementText,
                color = assistiveElementColor,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.padding(start = 16.dp)
            )

            OutlinedTextField(
                value = viewModel.valor,
                label = {
                    Text(
                        text = "Age",
                        fontStyle = FontStyle.Normal
                    )
                },
                onValueChange = {
                    viewModel.valor = it
                    error = false
                },
                isError = error,
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequesterValor),

                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            val assistiveText = if (error)
                "Error: Obligatorio" else "*Obligatorio"
            val assistiveColor = if (error) {
                MaterialTheme
                    .colors
                    .error
            } else {
                MaterialTheme
                    .colors
                    .onSurface
                    .copy(alpha = ContentAlpha.medium)
            }
            Text(
                text = assistiveText,
                color = assistiveColor,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.padding(start = 16.dp)
            )

            OutlinedTextField(
                value = viewModel.telefono,
                label = {
                    Text(
                        text = "Telephone",
                        fontStyle = FontStyle.Normal
                    )
                },
                onValueChange = {
                    viewModel.telefono = it
                    error = false
                },
                isError = error,
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequesterTelefono),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Text(
                text = assistiveText,
                color = assistiveColor,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.padding(start = 16.dp)
            )


            OutlinedTextField(
                value = viewModel.imageUrl,
                label = {
                    Text(
                        text = "Image",
                        fontStyle = FontStyle.Normal
                    )
                },
                onValueChange = { viewModel.imageUrl = it },
                modifier = Modifier
                    .fillMaxWidth(),
            )

            Spacer(
                modifier = Modifier.width(20.dp)
            )
            Button(
                onClick = {
                    if (!viewModel.descripcion.isNullOrEmpty() ||
                        !viewModel.valor.isNullOrEmpty())
                    {
                        if (validar(viewModel.valor) == false) {
                            error = viewModel.valor.isBlank()
                            Toast.makeText(
                                validar,
                                "¡ERROR!",
                                Toast.LENGTH_LONG
                            ).show()
                            focusRequesterValor.requestFocus()
                        } else {
                            if (viewModel.valor.toDouble() <= 0) {
                                error = viewModel.valor.isBlank()
                                Toast.makeText(
                                    validar,
                                    "¡ERROR!",
                                    Toast.LENGTH_LONG
                                ).show()
                                focusRequesterValor.requestFocus()
                            }
                            else {
                                viewModel.Guardar()
                                navHostController.navigate("ListaHermanoScreen")
                                Toast.makeText(
                                    validar,
                                    "¡SAVE!",
                                    Toast.LENGTH_LONG
                                ).show()
                                viewModel.imageUrl = ""
                                viewModel.descripcion = ""
                                viewModel.valor = ""
                                viewModel.telefono = ""
                            }
                        }

                    } else {
                        error = viewModel.descripcion.isBlank()
                        Toast.makeText(
                            validar,
                            "¡ERROR!",
                            Toast.LENGTH_LONG
                        ).show()
                        focusRequesterDescripcion.requestFocus()
                    }
                },
                modifier = Modifier.padding(50.dp)
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.Save,
                    contentDescription = null,
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Text("  SAVE",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Black,
                    fontStyle = FontStyle.Normal
                )
            }
        }
    }
}

fun validar(valor: String): Boolean {

    try {
        valor.toDouble()
        return true

    } catch (nfe: NumberFormatException) {
        return false
    }
}