package com.mendozacreations.listahermano.data.dto

import android.widget.DatePicker
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Asistencias")
data class Asistencia(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val presente: String = "",
    val ausente: String = "",
    val fecha: String = ""
)