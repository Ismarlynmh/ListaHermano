package com.mendozacreations.listahermano.data.remote

import com.mendozacreations.listahermano.data.dto.HermanoDto

data class ListStateHermano (
    val isLoading: Boolean = false,
    val hermanos: List<HermanoDto> = emptyList(),
    val error: String = ""
)