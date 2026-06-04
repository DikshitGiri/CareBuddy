package com.team.carebuddy.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.team.carebuddy.data.entity.CareReminderEntity

@Database(
    entities = [CareReminderEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class CareBuddyDatabase : RoomDatabase() {
    abstract val dao: CareReminderDao
}
