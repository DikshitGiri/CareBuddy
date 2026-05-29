package com.waseefakhtar.carebuddy

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.waseefakhtar.carebuddy.analytics.AnalyticsEvents
import com.waseefakhtar.carebuddy.analytics.AnalyticsHelper
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

const val REMINDER_NOTIFICATION = "reminder_notification"

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var analyticsHelper: AnalyticsHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CareBuddyApp(analyticsHelper = analyticsHelper)
        }
        parseIntent(intent)
    }

    private fun parseIntent(intent: Intent?) {
        val isReminderNotification = intent?.getBooleanExtra(REMINDER_NOTIFICATION, false) ?: false
        if (isReminderNotification) {
            analyticsHelper.logEvent(AnalyticsEvents.REMINDER_NOTIFICATION_CLICKED)
        }
    }
}
