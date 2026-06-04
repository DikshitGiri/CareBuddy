package com.team.carebuddy.feature.history.viewmodel

import com.team.carebuddy.domain.model.Medication

data class HistoryState(
    val medications: List<Medication> = emptyList()
)
