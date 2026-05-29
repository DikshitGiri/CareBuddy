package com.waseefakhtar.carebuddy.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.waseefakhtar.carebuddy.util.CareReminderType
import java.util.Date

@Entity
data class CareReminderEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val dosage: Int,
    val recurrence: String,
    val startDate: Date?,
    val endDate: Date,
    val reminderTaken: Boolean,
    val reminderTime: Date,
    @ColumnInfo(defaultValue = "TABLET")
    val type: String = CareReminderType.getDefault().name
)
