package com.waseefakhtar.carebuddy.extension

import com.waseefakhtar.carebuddy.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

data class Duration(
    val primary: Int,
    val primaryType: DurationType,
    val remainder: Int? = null,
    val remainderType: DurationType? = null,
)

fun Long.calculateDurationInDays(endMillis: Long): Int =
    ((endMillis - this) / (24 * 60 * 60 * 1000)).toInt() + 1

fun Long.formatDuration(endMillis: Long): Duration {
    val totalDays = calculateDurationInDays(endMillis)

    return when {
        totalDays >= 365 -> {
            val years = totalDays / 365
            val remainingDays = totalDays % 365
            when {
                remainingDays >= 30 ->
                    Duration(
                        primary = years,
                        primaryType = DurationType.YEARS,
                        remainder = remainingDays / 30,
                        remainderType = DurationType.MONTHS,
                    )
                remainingDays > 0 ->
                    Duration(
                        primary = years,
                        primaryType = DurationType.YEARS,
                        remainder = remainingDays,
                        remainderType = DurationType.DAYS,
                    )
                else -> Duration(
                    primary = years,
                    primaryType = DurationType.YEARS,
                )
            }
        }
        totalDays >= 30 -> {
            val months = totalDays / 30
            val remainingDays = totalDays % 30
            if (remainingDays > 0) {
                Duration(
                    primary = months,
                    primaryType = DurationType.MONTHS,
                    remainder = remainingDays,
                    remainderType = DurationType.DAYS,
                )
            } else {
                Duration(
                    primary = months,
                    primaryType = DurationType.MONTHS,
                )
            }
        }
        totalDays >= 7 -> {
            val weeks = totalDays / 7
            val remainingDays = totalDays % 7
            if (remainingDays > 0) {
                Duration(
                    primary = weeks,
                    primaryType = DurationType.WEEKS,
                    remainder = remainingDays,
                    remainderType = DurationType.DAYS,
                )
            } else {
                Duration(
                    primary = weeks,
                    primaryType = DurationType.WEEKS,
                )
            }
        }
        else -> Duration(
            primary = totalDays,
            primaryType = DurationType.DAYS,
        )
    }
}

enum class DurationType(
    val pluralResId: Int,
) {
    DAYS(R.plurals.duration_days),
    WEEKS(R.plurals.duration_weeks),
    MONTHS(R.plurals.duration_months),
    YEARS(R.plurals.duration_years),
}

fun Date.toFormattedDateString(): String {
    val sdf = SimpleDateFormat("EEEE, LLLL dd", Locale.getDefault())
    return sdf.format(this)
}

fun Date.toFormattedMonthDateString(): String {
    val sdf = SimpleDateFormat("MMMM dd", Locale.getDefault())
    return sdf.format(this)
}

fun Date.toFormattedYearMonthDateString(): String {
    val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return sdf.format(this)
}

fun String.toDate(): Date? {
    return try {
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        sdf.parse(this)
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}

fun Date.toFormattedDateShortString(): String {
    val sdf = SimpleDateFormat("dd", Locale.getDefault())
    return sdf.format(this)
}

fun Long.toFormattedDateString(): String {
    val sdf = SimpleDateFormat("LLLL dd, yyyy", Locale.getDefault())
    return sdf.format(this)
}

fun Date.toFormattedTimeString(): String {
    val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
    return timeFormat.format(this)
}

fun Date.hasPassed(): Boolean {
    val calendar = Calendar.getInstance()
    calendar.add(Calendar.SECOND, -1)
    val oneSecondAgo = calendar.time
    return time < oneSecondAgo.time
}
