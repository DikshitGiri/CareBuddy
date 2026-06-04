package com.team.carebuddy.data.repository

import com.team.carebuddy.data.CareReminderDao
import com.team.carebuddy.data.mapper.toCareReminder
import com.team.carebuddy.data.mapper.toCareReminderEntity
import com.team.carebuddy.domain.model.CareReminder
import com.team.carebuddy.domain.repository.CareReminderRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class CareReminderRepositoryImpl(
    private val dao: CareReminderDao
) : CareReminderRepository {

    override suspend fun insertCareReminders(reminders: List<CareReminder>): Flow<List<CareReminder>> = flow {
        val savedReminders = reminders.map { reminder ->
            val id = dao.insertCareReminder(reminder.toCareReminderEntity())
            reminder.copy(id = id)
        }
        emit(savedReminders)
    }

    override suspend fun deleteCareReminder(reminder: CareReminder) {
        dao.deleteCareReminder(reminder.toCareReminderEntity())
    }

    override suspend fun updateCareReminder(reminder: CareReminder) {
        dao.updateCareReminder(reminder.toCareReminderEntity())
    }

    override fun getAllCareReminders(): Flow<List<CareReminder>> {
        return dao.getAllCareReminders().map { entities ->
            entities.map { it.toCareReminder() }
        }
    }

    override fun getCareRemindersForDate(date: String): Flow<List<CareReminder>> {
        return dao.getCareRemindersForDate(date).map { entities ->
            entities.map { it.toCareReminder() }
        }
    }

    override suspend fun getCareReminderById(id: Long): CareReminder? {
        return dao.getCareReminderById(id)?.toCareReminder()
    }
}
