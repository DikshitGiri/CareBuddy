package com.waseefakhtar.carebuddy.feature.history.viewmodel

import com.waseefakhtar.carebuddy.domain.model.Medication

data class HistoryState(
    val medications: List<Medication> = emptyList()
)
