package com.my.diary.mood.ui.screen.home

import androidx.lifecycle.viewModelScope
import com.my.diary.mood.data.MoodItem
import com.my.diary.mood.domain.MoodItemRepository
import com.my.diary.mood.ui.BaseViewModel
import com.my.diary.mood.ui.screen.home.data.MoodItemData
import com.my.diary.mood.util.TimeProvider
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: MoodItemRepository,
    private val timeProvider: TimeProvider
) : BaseViewModel() {

    fun addMoodItem(data: MoodItemData) {
        viewModelScope.launch {
            val currentTime = timeProvider.currentTime
            repository.addMoodItem(
                MoodItem(
                    type = data.type,
                    description = data.description,
                    rate = data.rate,
                    timestamp = currentTime
                )
            )
        }
    }

}