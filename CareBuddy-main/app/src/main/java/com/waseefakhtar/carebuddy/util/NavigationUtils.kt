package com.waseefakhtar.carebuddy.util

import androidx.navigation.NavHostController

fun NavHostController.navigateSingleTop(route: String) {
    this.navigate(route) {
        popUpTo(route)
        launchSingleTop = true
    }
}
