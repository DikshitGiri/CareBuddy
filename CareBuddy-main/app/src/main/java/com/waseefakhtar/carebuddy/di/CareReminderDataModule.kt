package com.waseefakhtar.carebuddy.di

import android.app.Application
import androidx.room.Room
import com.waseefakhtar.carebuddy.data.CareBuddyDatabase
import com.waseefakhtar.carebuddy.data.repository.CareReminderRepositoryImpl
import com.waseefakhtar.carebuddy.domain.repository.CareReminderRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CareReminderDataModule {

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
    fun provideCareBuddyDatabase(app: Application): CareBuddyDatabase {
        return Room.databaseBuilder(
            app,
            CareBuddyDatabase::class.java,
            "care_buddy_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideCareReminderRepository(
        db: CareBuddyDatabase
    ): CareReminderRepository {
        return CareReminderRepositoryImpl(
            dao = db.dao
        )
    }
}
