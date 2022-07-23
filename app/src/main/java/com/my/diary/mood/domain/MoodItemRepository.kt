package com.my.diary.mood.domain

import com.my.diary.mood.data.MoodItem
import com.my.diary.mood.db.MoodItemDao
import com.my.diary.mood.db.MoodItemEntity

class MoodItemRepository(
    private val dao: MoodItemDao
) {

    suspend fun getAllMoodItems() {
        dao.getAll().map {
            MoodItem(
                description = it.description,
                rate = it.rate,
                type = it.type,
                timestamp = it.timestamp
            )
        }
    }

    suspend fun addMoodItem(moodItem: MoodItem) {
        dao.add(
            MoodItemEntity(
                description = moodItem.description,
                type = moodItem.type,
                rate = moodItem.rate,
                timestamp = moodItem.timestamp
            )
        )
    }


}