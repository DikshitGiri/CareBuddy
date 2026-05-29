package com.waseefakhtar.carebuddy.feature.medicationconfirm.viewmodel

import com.waseefakhtar.carebuddy.domain.model.Medication

data class MedicationConfirmState(
    val medications: List<Medication>
)
