package com.my.diary.mood.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MoodItemEntity::class], version = 1, exportSchema = false)
abstract class DairyDatabase : RoomDatabase() {

    abstract fun getMoodItemDao(): MoodItemDao

}