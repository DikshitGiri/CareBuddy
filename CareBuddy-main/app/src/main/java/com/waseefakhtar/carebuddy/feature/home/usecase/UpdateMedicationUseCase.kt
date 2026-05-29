package com.waseefakhtar.carebuddy.feature.home.usecase

import com.waseefakhtar.carebuddy.domain.model.Medication
import com.waseefakhtar.carebuddy.domain.repository.MedicationRepository
import javax.inject.Inject

class UpdateMedicationUseCase @Inject constructor(
    private val repository: MedicationRepository
) {

    suspend fun updateMedication(medication: Medication) {
        return repository.updateMedication(medication)
    }
}
