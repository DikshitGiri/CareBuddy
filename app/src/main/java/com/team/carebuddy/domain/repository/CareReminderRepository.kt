package com.team.carebuddy.domain.repository

import com.team.carebuddy.domain.model.CareReminder
import kotlinx.coroutines.flow.Flow

interface CareReminderRepository {

    suspend fun insertCareReminders(reminders: List<CareReminder>): Flow<List<CareReminder>>

    suspend fun deleteCareReminder(reminder: CareReminder)

    suspend fun updateCareReminder(reminder: CareReminder)

    fun getAllCareReminders(): Flow<List<CareReminder>>

    fun getCareRemindersForDate(date: String): Flow<List<CareReminder>>

    suspend fun getCareReminderById(id: Long): CareReminder?
}
