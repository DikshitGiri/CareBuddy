package com.waseefakhtar.carebuddy.data.repository

import com.waseefakhtar.carebuddy.data.CareReminderDao
import com.waseefakhtar.carebuddy.data.mapper.toCareReminder
import com.waseefakhtar.carebuddy.data.mapper.toCareReminderEntity
import com.waseefakhtar.carebuddy.domain.model.CareReminder
import com.waseefakhtar.carebuddy.domain.repository.CareReminderRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class CareReminderRepositoryImpl(
    private val dao: CareReminderDao
) : CareReminderRepository {

    override suspend fun insertCareReminders(reminders: List<CareReminder>): Flow<List<CareReminder>> = flow {
        val savedIds = reminders.map { reminder ->
            dao.insertCareReminder(reminder.toCareReminderEntity())
        }
        val savedReminders = reminders.mapIndexed { index, reminder ->
            reminder.copy(id = savedIds[index])
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
