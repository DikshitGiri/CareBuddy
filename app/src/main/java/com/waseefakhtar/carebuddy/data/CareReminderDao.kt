package com.waseefakhtar.carebuddy.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.waseefakhtar.carebuddy.data.entity.CareReminderEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CareReminderDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCareReminder(careReminderEntity: CareReminderEntity): Long

    @Delete
    suspend fun deleteCareReminder(careReminderEntity: CareReminderEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateCareReminder(careReminderEntity: CareReminderEntity)

    @Query(
        """
            SELECT *
            FROM carereminderentity
        """
    )
    fun getAllCareReminders(): Flow<List<CareReminderEntity>>

    @Query(
        """
            SELECT *
            FROM carereminderentity
            WHERE strftime('%Y-%m-%d', reminderTime / 1000, 'unixepoch', 'localtime') = :date
            ORDER BY reminderTime ASC
        """
    )
    fun getCareRemindersForDate(date: String): Flow<List<CareReminderEntity>>

    @Query("SELECT * FROM carereminderentity WHERE id = :id")
    suspend fun getCareReminderById(id: Long): CareReminderEntity?
}
