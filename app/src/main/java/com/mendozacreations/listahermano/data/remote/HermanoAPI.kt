package com.mendozacreations.listahermano.data.remote

import com.mendozacreations.listahermano.data.dto.HermanoDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface HermanoAPI {
    @GET("/Hermanos")
    suspend fun getHermanos(): List<HermanoDto>

    @POST("/Hermanos")
    suspend fun postHermano(@Body hermanoDto: HermanoDto): HermanoDto
}