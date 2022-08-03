package com.mendozacreations.listahermano.data.repository

import com.mendozacreations.listahermano.data.dto.Asistencia
import com.mendozacreations.listahermano.data.dto.AsistenciaDao
import com.mendozacreations.listahermano.data.dto.AsistenciasDb
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AsistenciaRepository @Inject constructor(
    val db: AsistenciasDb
) {

    suspend fun insertAsistencia(asistencia: Asistencia) {
        db.asistenciaDao.insertAsistencia(asistencia)
    }

    suspend fun deleteAsistencia(asistencia: Asistencia) {
        db.asistenciaDao.deleteAsistencia(asistencia)
    }

    fun buscar(id: Int) = db.asistenciaDao.buscar(id)

    fun getList() = db.asistenciaDao.getList()


/*

    suspend fun insertar(asistencia: Asistencia ){
        asistenciaDao.insertar(asistencia)
    }

    suspend fun eliminar(asistencia : Asistencia){
        asistenciaDao.eliminar(asistencia)
    }

    fun buscar(presente: String): Flow<Asistencia> {
        return   asistenciaDao.buscar(presente)
    }

    fun getList(): Flow<List<Asistencia>> {
        return  asistenciaDao.getList()
    }*/
}