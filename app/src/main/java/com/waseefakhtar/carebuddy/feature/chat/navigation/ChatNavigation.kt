package com.waseefakhtar.carebuddy.feature.chat.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.waseefakhtar.carebuddy.core.navigation.CareBuddyNavigationDestination
import com.waseefakhtar.carebuddy.feature.chat.ChatRoute

object ChatDestination : CareBuddyNavigationDestination {
    override val route = "chat_route"
    override val destination = "chat_destination"
}

fun NavGraphBuilder.chatGraph(bottomBarVisibility: MutableState<Boolean>, fabVisibility: MutableState<Boolean>) {
    composable(route = ChatDestination.route) {
        LaunchedEffect(null) {
            bottomBarVisibility.value = true
            fabVisibility.value = false // Hide FAB in chat
        }
        ChatRoute()
    }
}
