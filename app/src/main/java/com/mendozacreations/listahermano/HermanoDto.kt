package com.mendozacreations.listahermano
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HermanoDto (
    val hermanoId: Int = 0,
    val imageUrl: String = "",
    val descripcion: String = "",
    val valor: String = "",
    val telefono: String = ""
)
