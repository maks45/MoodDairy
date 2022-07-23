package com.my.diary.mood.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.my.diary.mood.data.MoodType

@Entity(tableName = "mood_item")
data class MoodItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val type: MoodType,
    val rate: Int,
    val description: String,
    val timestamp: Long
)