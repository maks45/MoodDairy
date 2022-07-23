package com.my.diary.mood.di

import androidx.room.Room
import com.my.diary.mood.db.DairyDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val KoinPersistenceModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            DairyDatabase::class.java,
            "mood_diary_database"
        ).build()
    }

    single {
        val db: DairyDatabase = get()
        db.getMoodItemDao()
    }

}
