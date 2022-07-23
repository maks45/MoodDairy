package com.my.diary.mood.data

import com.my.diary.mood.ui.screen.home.data.MoodItemViewData

enum class MoodType {
    HAPPY,
    EXCITING,
    NOTHING,
    ANGER,
    SAD,
    DEPRESSED,
    ANXIETY
}

fun MoodType.mapToViewData(): MoodItemViewData {
    return when (this) {
        MoodType.HAPPY -> MoodItemViewData.Happy
        MoodType.EXCITING -> MoodItemViewData.Exciting
        MoodType.NOTHING -> MoodItemViewData.Nothing
        MoodType.ANGER -> MoodItemViewData.Anger
        MoodType.SAD -> MoodItemViewData.Sad
        MoodType.DEPRESSED -> MoodItemViewData.Depressed
        MoodType.ANXIETY -> MoodItemViewData.Anxiety
    }
}
