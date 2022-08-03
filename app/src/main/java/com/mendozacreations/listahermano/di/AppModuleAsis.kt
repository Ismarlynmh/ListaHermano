package com.mendozacreations.listahermano.di

import android.content.Context
import androidx.room.Room
import com.mendozacreations.listahermano.data.dto.AsistenciaDao
import com.mendozacreations.listahermano.data.dto.AsistenciasDb
import com.mendozacreations.listahermano.data.repository.AsistenciaRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModuleAsis {
    @Provides
    @Singleton
    fun providesAsistenciasDb(@ApplicationContext context: Context):AsistenciasDb{
        return  Room.databaseBuilder(
            context,
            AsistenciasDb::class.java,
            "AsistenciasDb")
            .fallbackToDestructiveMigration()
            .build()
    }
}