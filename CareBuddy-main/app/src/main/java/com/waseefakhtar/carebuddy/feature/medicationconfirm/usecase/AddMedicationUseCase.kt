package com.waseefakhtar.carebuddy.feature.medicationconfirm.usecase

import com.waseefakhtar.carebuddy.domain.model.Medication
import com.waseefakhtar.carebuddy.domain.repository.MedicationRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AddMedicationUseCase @Inject constructor(
    private val repository: MedicationRepository
) {
    suspend fun addMedication(medications: List<Medication>): Flow<List<Medication>> = repository.insertMedications(medications)
}
