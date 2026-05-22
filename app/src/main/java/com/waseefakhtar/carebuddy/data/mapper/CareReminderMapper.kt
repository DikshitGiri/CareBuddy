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
        frequency = recurrence,
        startDate = startDate ?: Date(),
        endDate = endDate,
        reminderTime = reminderTime,
        reminderTaken = reminderTaken,
        type = CareReminderType.valueOf(type)
    )
}

fun CareReminder.toCareReminderEntity(): CareReminderEntity {
    return CareReminderEntity(
        id = id,
        name = name,
        dosage = dosage,
        recurrence = frequency,
        startDate = startDate,
        endDate = endDate,
        reminderTime = reminderTime,
        reminderTaken = reminderTaken,
        type = type.name
    )
}
