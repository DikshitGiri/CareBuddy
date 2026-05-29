package com.team.carebuddy.domain.model

import android.os.Parcelable
import com.team.carebuddy.util.CareReminderType
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class CareReminder(
    val id: Long = 0,
    val name: String,
    val dosage: Int,
    val recurrence: String,
    val startDate: Date,
    val endDate: Date,
    val isTaken: Boolean,
    val reminderTime: Date,
    val type: CareReminderType = CareReminderType.getDefault()
) : Parcelable
