package com.team.carebuddy.feature.medicationconfirm.usecase

import com.team.carebuddy.domain.model.Medication
import com.team.carebuddy.domain.repository.MedicationRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AddMedicationUseCase @Inject constructor(
    private val repository: MedicationRepository
) {
    suspend fun addMedication(medications: List<Medication>): Flow<List<Medication>> = repository.insertMedications(medications)
}
