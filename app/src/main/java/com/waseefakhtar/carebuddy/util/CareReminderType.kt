package com.waseefakhtar.carebuddy.util

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

enum class CareReminderType {
    TABLET,
    CAPSULE,
    SYRUP,
    DROPS,
    SPRAY,
    GEL;

    companion object {
        fun getDefault() = TABLET
    }

    @Composable
    fun getCardColor() = when (this) {
        TABLET -> Triple(
            MaterialTheme.colorScheme.primaryContainer,
            MaterialTheme.colorScheme.primary,
            MaterialTheme.colorScheme.onPrimaryContainer
        )
        CAPSULE -> Triple(
            MaterialTheme.colorScheme.secondaryContainer,
            MaterialTheme.colorScheme.secondary,
            MaterialTheme.colorScheme.onSecondaryContainer
        )
        SYRUP -> Triple(
            MaterialTheme.colorScheme.tertiaryContainer,
            MaterialTheme.colorScheme.tertiary,
            MaterialTheme.colorScheme.onTertiaryContainer
        )
        DROPS -> Triple(
            MaterialTheme.colorScheme.surfaceVariant,
            MaterialTheme.colorScheme.primary,
            MaterialTheme.colorScheme.onSurfaceVariant
        )
        SPRAY -> Triple(
            MaterialTheme.colorScheme.errorContainer,
            MaterialTheme.colorScheme.error,
            MaterialTheme.colorScheme.onErrorContainer
        )
        GEL -> Triple(
            MaterialTheme.colorScheme.inversePrimary,
            MaterialTheme.colorScheme.primary,
            MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}

fun getCareReminderTypes(): List<CareReminderType> = CareReminderType.values().toList()
