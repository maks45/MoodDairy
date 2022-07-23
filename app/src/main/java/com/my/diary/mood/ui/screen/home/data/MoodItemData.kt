package com.my.diary.mood.ui.screen.home.data

import com.my.diary.mood.data.MoodType

data class MoodItemData(
    val description: String,
    val type: MoodType,
    val rate: Int,

)
