package com.my.diary.mood

import android.app.Application
import com.my.diary.mood.di.KoinHistoryModule
import com.my.diary.mood.di.KoinHomeModule
import com.my.diary.mood.di.KoinPersistenceModule
import com.my.diary.mood.di.KoinSettingsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DiaryApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@DiaryApp)
            modules(
                KoinPersistenceModule,
                KoinHomeModule,
                KoinHistoryModule,
                KoinSettingsModule
            )
        }
    }
}