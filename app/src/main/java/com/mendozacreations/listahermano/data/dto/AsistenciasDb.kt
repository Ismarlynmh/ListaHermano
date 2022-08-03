package com.mendozacreations.listahermano.data.dto

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        Asistencia::class
    ],
    exportSchema = false,
    version = 1
)
abstract class AsistenciasDb : RoomDatabase() {
    abstract val asistenciaDao: AsistenciaDao
}