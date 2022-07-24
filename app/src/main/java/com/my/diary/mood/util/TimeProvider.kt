package com.my.diary.mood.util

import android.text.format.DateFormat
import android.text.format.DateUtils

object TimeProvider {
    private const val TIME_FORMAT = "dd.MM.yyyy hh:mm"
    private const val TIME_FORMAT_TODAY = "Today hh:mm"
    val currentTime = System.currentTimeMillis()

    fun formatTime(ts: Long): String {
        return DateFormat.format(if (DateUtils.isToday(ts)) TIME_FORMAT_TODAY else TIME_FORMAT, ts)
            .toString()
    }
}