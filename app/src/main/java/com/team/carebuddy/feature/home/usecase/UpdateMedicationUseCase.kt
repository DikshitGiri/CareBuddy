package com.team.carebuddy.feature.home.usecase

import com.team.carebuddy.domain.model.Medication
import com.team.carebuddy.domain.repository.MedicationRepository
import javax.inject.Inject

class UpdateMedicationUseCase @Inject constructor(
    private val repository: MedicationRepository
) {

    suspend fun updateMedication(medication: Medication) {
        return repository.updateMedication(medication)
    }
}
