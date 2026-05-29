package com.waseefakhtar.carebuddy.feature.medicationdetail.usecase

import com.waseefakhtar.carebuddy.domain.model.Medication
import com.waseefakhtar.carebuddy.domain.repository.MedicationRepository
import javax.inject.Inject

class GetMedicationUseCase @Inject constructor(
    private val repository: MedicationRepository
) {
    suspend operator fun invoke(id: Long): Medication? = repository.getMedicationById(id)
}
