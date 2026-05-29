package com.team.carebuddy.data.mapper

import com.team.carebuddy.data.entity.MedicationEntity
import com.team.carebuddy.domain.model.Medication
import com.team.carebuddy.util.MedicationType
import java.util.Date

fun MedicationEntity.toMedication(): Medication {
    return Medication(
        id = id,
        name = name,
        dosage = dosage,
        frequency = recurrence,
        startDate = startDate ?: Date(),
        endDate = endDate,
        medicationTime = medicationTime,
        medicationTaken = medicationTaken,
        type = MedicationType.valueOf(type)
    )
}

fun Medication.toMedicationEntity(): MedicationEntity {
    return MedicationEntity(
        id = id,
        name = name,
        dosage = dosage,
        recurrence = frequency,
        startDate = startDate,
        endDate = endDate,
        medicationTime = medicationTime,
        medicationTaken = medicationTaken,
        type = type.name
    )
}
