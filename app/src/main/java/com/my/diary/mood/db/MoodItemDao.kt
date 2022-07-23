package com.my.diary.mood.db

import androidx.room.*

@Dao
abstract class MoodItemDao {
    @Query("SELECT * FROM mood_item")
    abstract fun getAll(): List<MoodItemEntity>

    @Insert
    abstract fun add(entity: MoodItemEntity)

    @Update
    abstract fun update(entity: MoodItemEntity)

    @Delete
    abstract fun delete(entity: MoodItemEntity)
}
