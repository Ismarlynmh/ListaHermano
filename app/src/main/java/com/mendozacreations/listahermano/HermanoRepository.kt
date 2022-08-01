package com.mendozacreations.listahermano

import androidx.compose.ui.semantics.SemanticsProperties.Error
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class HermanoRepository @Inject constructor(
    private val api: HermanoAPI
){
    fun getHermano(): Flow<Resource<List<HermanoDto>>> = flow {
        try {
            emit(Resource.Loading()) //indicar que estamos cargando

            val hermano = api.getHermanos() //descarga las monedas de interneto

            emit(Resource.Success(hermano)) //se cargo correctamente y pasarle las monedas
        } catch (e: HttpException) {
            //error general HTTP
            emit(Resource.Error(e.message ?: "Error HTTP GENERAL"))
        } catch (e: IOException) {
            //debe verificar tu conexion a internet
            emit(Resource.Error(e.message ?: "verificar tu conexion a internet"))
        }
    }

    suspend fun Inser(hermanoDto: HermanoDto){
        api.postHermano(hermanoDto)
    }
}