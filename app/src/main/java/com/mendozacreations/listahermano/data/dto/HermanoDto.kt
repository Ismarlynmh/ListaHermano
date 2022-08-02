package com.mendozacreations.listahermano.data.dto
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HermanoDto (
    val hermanoId: Int = 0,
    val imageUrl: String = "",
    val descripcion: String = "",
    val valor: String = "",
    val telefono: String = ""
)
