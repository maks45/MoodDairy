package com.my.diary.mood.ui.screen.home.data


import androidx.annotation.StringRes
import com.my.diary.mood.R
import com.my.diary.mood.data.MoodType

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

fun MoodItemViewData.mapToMoodType(): MoodType {
    return when (this) {
        is MoodItemViewData.Happy -> MoodType.HAPPY
        is MoodItemViewData.Exciting -> MoodType.EXCITING
        is MoodItemViewData.Nothing -> MoodType.NOTHING
        is MoodItemViewData.Anger -> MoodType.ANGER
        is MoodItemViewData.Anxiety -> MoodType.ANXIETY
        is MoodItemViewData.Depressed -> MoodType.DEPRESSED
        is MoodItemViewData.Sad -> MoodType.SAD
    }
}

