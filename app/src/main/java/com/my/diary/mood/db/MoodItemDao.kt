package com.my.diary.mood.db

import androidx.room.*

@Dao
abstract class MoodItemDao {
    @Query("SELECT * FROM mood_item")
    abstract suspend fun getAll(): List<MoodItemEntity>

    @Insert
    abstract suspend fun add(entity: MoodItemEntity)

    @Update
    abstract suspend fun update(entity: MoodItemEntity)

    @Delete
    abstract suspend fun delete(entity: MoodItemEntity)
}
