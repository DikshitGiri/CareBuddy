package com.team.carebuddy.di

import android.content.Context
import com.team.carebuddy.MedicationNotificationService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NotificationModule {
    @Provides
    @Singleton
    fun provideMedicationNotificationService(
        @ApplicationContext context: Context,
    ): MedicationNotificationService = MedicationNotificationService(context)
}
