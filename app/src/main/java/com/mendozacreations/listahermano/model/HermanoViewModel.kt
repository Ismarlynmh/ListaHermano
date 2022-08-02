package com.mendozacreations.listahermano.model

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mendozacreations.listahermano.data.dto.HermanoDto
import com.mendozacreations.listahermano.data.remote.ListStateHermano
import com.mendozacreations.listahermano.data.repository.HermanoRepository
import com.mendozacreations.listahermano.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HermanoViewModel @Inject constructor(
    private val hermanoRepository: HermanoRepository
) : ViewModel(){



    var imageUrl by mutableStateOf("")
    var descripcion by mutableStateOf("")
    var valor by mutableStateOf("")
    var telefono by mutableStateOf("")

    private var _state = mutableStateOf(ListStateHermano())
    val state: State<ListStateHermano> = _state

    init {
        recargarLista()
    }

    fun recargarLista(){
        hermanoRepository.getHermano().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = ListStateHermano(isLoading = true)
                }

                is Resource.Success -> {
                    _state.value = ListStateHermano(hermanos = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = ListStateHermano(error = result.message ?: "Error desconocido")
                }
            }
        }.launchIn(viewModelScope)


        viewModelScope.launch {
            hermanoRepository.getHermano().collect {
                _state.value = ListStateHermano(hermanos = it.data ?: emptyList())
            }
        }

    }

    fun Guardar() {
        viewModelScope.launch {
            hermanoRepository.Inser(
                HermanoDto(
                    imageUrl = imageUrl,
                    descripcion = descripcion,
                    valor = valor,
                    telefono = telefono,
                )
            )
        }
    }
}