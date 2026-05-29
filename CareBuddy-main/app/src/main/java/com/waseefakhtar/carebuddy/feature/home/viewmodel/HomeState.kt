package com.waseefakhtar.carebuddy.feature.home.viewmodel

import com.waseefakhtar.carebuddy.domain.model.Medication

data class HomeState(
    val greeting: String = "",
    val userName: String = "",
    val lastSelectedDate: String,
    val medications: List<Medication> = emptyList()
)
