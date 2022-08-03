package com.mendozacreations.listahermano.model

import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mendozacreations.listahermano.data.dto.Asistencia
import com.mendozacreations.listahermano.data.repository.AsistenciaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class AsistenciaViewModel @Inject constructor(
    val asistenciaRepository: AsistenciaRepository,
) : ViewModel(){

    var asistencia = asistenciaRepository.getList()

    var ausente by mutableStateOf("")
    var presente by mutableStateOf("")
    var fecha by mutableStateOf("")



    fun guardar(){
        viewModelScope.launch {
            asistenciaRepository.insertAsistencia(
                Asistencia(
                    presente = presente,
                    ausente = ausente,
                    fecha = fecha
                )
            )
        }
    }
}