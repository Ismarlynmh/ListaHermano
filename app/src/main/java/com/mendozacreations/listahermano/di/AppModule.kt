package com.mendozacreations.listahermano.di

import com.mendozacreations.listahermano.data.remote.HermanoAPI
import com.mendozacreations.listahermano.data.repository.HermanoRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideHermanoAPI(moshi: Moshi): HermanoAPI {
        return Retrofit.Builder()
            .baseUrl("http://listaokhermano.somee.com")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(HermanoAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideHermanoRepository(hermanoAPI: HermanoAPI): HermanoRepository {
        return HermanoRepository(hermanoAPI)
    }
}