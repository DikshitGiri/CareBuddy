package com.team.carebuddy.feature.medicationdetail.usecase

import com.team.carebuddy.domain.model.Medication
import com.team.carebuddy.domain.repository.MedicationRepository
import javax.inject.Inject

class GetMedicationUseCase @Inject constructor(
    private val repository: MedicationRepository
) {
    suspend operator fun invoke(id: Long): Medication? = repository.getMedicationById(id)
}
