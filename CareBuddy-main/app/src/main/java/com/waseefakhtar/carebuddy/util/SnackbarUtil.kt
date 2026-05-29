package com.waseefakhtar.carebuddy.util

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

object SnackbarUtil {
    private val snackbarMessage = mutableStateOf<String?>(null)
    private val snackbarVisible = mutableStateOf(false)

    fun showSnackbar(message: String) {
        snackbarMessage.value = message
        snackbarVisible.value = true
    }

    fun hideSnackbar() {
        snackbarVisible.value = false
    }

    fun getSnackbarMessage() = snackbarMessage
    fun isSnackbarVisible() = snackbarVisible

    @Composable
    fun SnackbarWithoutScaffold(
        message: String?,
        visible: Boolean,
        onDismiss: () -> Unit
    ) {
        val snackbarHostState = remember { SnackbarHostState() }
        if (visible && message != null) {
            LaunchedEffect(message) {
                snackbarHostState.showSnackbar(message)
                onDismiss()
            }
        }
    }
}
