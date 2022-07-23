package com.my.diary.mood.di

import com.my.diary.mood.domain.MoodItemRepository
import com.my.diary.mood.ui.screen.home.HomeViewModel
import com.my.diary.mood.util.TimeProvider
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val KoinHomeModule = module {

    single {
        MoodItemRepository(
            dao = get()
        )
    }

    viewModel {
        HomeViewModel(
            repository = get(),
            timeProvider = TimeProvider
        )
    }
}