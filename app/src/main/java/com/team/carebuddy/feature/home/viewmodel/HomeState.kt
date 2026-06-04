package com.team.carebuddy.feature.home.viewmodel

import com.team.carebuddy.domain.model.Medication

data class HomeState(
    val greeting: String = "",
    val userName: String = "",
    val lastSelectedDate: String,
    val medications: List<Medication> = emptyList()
)
