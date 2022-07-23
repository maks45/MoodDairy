package com.my.diary.mood.data

data class MoodItem(
    val type: MoodType,
    val rate: Int,
    val description: String,
    val timestamp: Long,
)

