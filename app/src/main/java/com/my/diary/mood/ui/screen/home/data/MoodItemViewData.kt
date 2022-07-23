package com.my.diary.mood.ui.screen.home.data


import androidx.annotation.StringRes
import com.my.diary.mood.R

sealed class MoodItemViewData(
    @StringRes val moodName: Int
) {
    object Happy : MoodItemViewData(moodName = R.string.home_mood_happy)
    object Exciting : MoodItemViewData(moodName = R.string.home_mood_exciting)
    object Nothing : MoodItemViewData(moodName = R.string.home_mood_nothing)
    object Anger : MoodItemViewData(moodName = R.string.home_mood_anger)
    object Sad : MoodItemViewData(moodName = R.string.home_mood_sad)
    object Depressed : MoodItemViewData(moodName = R.string.home_mood_depressed)
    object Anxiety : MoodItemViewData(moodName = R.string.home_mood_anxiety)
}

