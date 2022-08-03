package com.mendozacreations.listahermano.data.dto

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface AsistenciaDao {
    @Insert
    suspend fun insertAsistencia(asistencia: Asistencia)

    @Delete
    suspend fun deleteAsistencia(asistencia: Asistencia)

    @Query("SELECT * FROM Asistencias WHERE id =:id ")
    fun buscar(id: Int): Flow<Asistencia>

    @Query("SELECT * FROM Asistencias")
    fun getList(): Flow<List<Asistencia>>
}