package com.waseefakhtar.carebuddy.data.mapper

import com.waseefakhtar.carebuddy.data.entity.CareReminderEntity
import com.waseefakhtar.carebuddy.domain.model.CareReminder
import com.waseefakhtar.carebuddy.util.CareReminderType
import java.util.Date

fun CareReminderEntity.toCareReminder(): CareReminder {
    return CareReminder(
        id = id,
        name = name,
        dosage = dosage,
        recurrence = recurrence,
        startDate = startDate ?: Date(),
        endDate = endDate,
        reminderTime = reminderTime,
        isTaken = reminderTaken,
        type = CareReminderType.valueOf(type)
    )
}

fun CareReminder.toCareReminderEntity(): CareReminderEntity {
    return CareReminderEntity(
        id = id,
        name = name,
        dosage = dosage,
        recurrence = recurrence,
        startDate = startDate,
        endDate = endDate,
        reminderTime = reminderTime,
        reminderTaken = isTaken,
        type = type.name
    )
}
