package com.waseefakhtar.carebuddy.di

import android.app.Application
import androidx.room.Room
import com.waseefakhtar.carebuddy.data.MedicationDatabase
import com.waseefakhtar.carebuddy.data.repository.MedicationRepositoryImpl
import com.waseefakhtar.carebuddy.domain.repository.MedicationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MedicationDataModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideMedicationDatabase(app: Application): MedicationDatabase {
        return Room.databaseBuilder(
            app,
            MedicationDatabase::class.java,
            "medication_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideMedicationRepository(
        db: MedicationDatabase
    ): MedicationRepository {
        return MedicationRepositoryImpl(
            dao = db.dao
        )
    }
}
