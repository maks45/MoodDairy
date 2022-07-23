package com.my.diary.mood.ui.screen.home

import androidx.lifecycle.viewModelScope
import com.my.diary.mood.data.MoodItem
import com.my.diary.mood.data.MoodType
import com.my.diary.mood.domain.MoodItemRepository
import com.my.diary.mood.ui.BaseViewModel
import com.my.diary.mood.util.TimeProvider
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: MoodItemRepository,
    private val timeProvider: TimeProvider
) : BaseViewModel() {

    fun createMoodItem(type: MoodType, description: String, rate: Int) {
        viewModelScope.launch {
            val timestamp = timeProvider.currentTime
            repository.addMoodItem(
                MoodItem(
                    type = type,
                    description = description,
                    rate = rate,
                    timestamp = timestamp
                )
            )
        }
    }

}