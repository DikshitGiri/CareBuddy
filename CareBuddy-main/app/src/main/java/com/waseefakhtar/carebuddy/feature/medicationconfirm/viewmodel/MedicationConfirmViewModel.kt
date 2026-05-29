package com.waseefakhtar.carebuddy.feature.medicationconfirm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.waseefakhtar.carebuddy.MedicationNotificationService
import com.waseefakhtar.carebuddy.analytics.AnalyticsHelper
import com.waseefakhtar.carebuddy.feature.medicationconfirm.usecase.AddMedicationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MedicationConfirmViewModel @Inject constructor(
    private val addMedicationUseCase: AddMedicationUseCase,
    private val medicationNotificationService: MedicationNotificationService,
    private val analyticsHelper: AnalyticsHelper
) : ViewModel() {
    private val _isMedicationSaved = MutableSharedFlow<Unit>()
    val isMedicationSaved = _isMedicationSaved.asSharedFlow()

    fun addMedication(state: MedicationConfirmState) {
        viewModelScope.launch {
            val medications = state.medications
            addMedicationUseCase.addMedication(medications).collect { savedMedications ->
                // Schedule notifications for saved medications that have proper IDs
                savedMedications.forEach { medication ->
                    medicationNotificationService.scheduleNotification(
                        medication = medication,
                        analyticsHelper = analyticsHelper
                    )
                }
                _isMedicationSaved.emit(Unit)
            }
        }
    }

    fun logEvent(eventName: String) {
        analyticsHelper.logEvent(eventName = eventName)
    }
}
