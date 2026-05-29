package com.waseefakhtar.doseapp.feature.home

import com.waseefakhtar.doseapp.domain.model.Medication

sealed class MedicationListItem {
    data class MedicationItem(val medication: Medication) : MedicationListItem()
    data class HeaderItem(val headerText: String) : MedicationListItem()
    object OverviewItem : MedicationListItem()
}
