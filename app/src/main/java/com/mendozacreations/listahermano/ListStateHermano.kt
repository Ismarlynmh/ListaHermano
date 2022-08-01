package com.mendozacreations.listahermano

data class ListStateHermano (
    val isLoading: Boolean = false,
    val hermanos: List<HermanoDto> = emptyList(),
    val error: String = ""
)