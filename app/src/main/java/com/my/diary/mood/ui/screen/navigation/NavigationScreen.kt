package com.my.diary.mood.ui.screen.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.my.diary.mood.R

sealed class NavigationScreen(
    val route: NavigationRoute,
    @StringRes val title: Int,
    @DrawableRes val icon: Int
) {
    object Home : NavigationScreen(
        route = NavigationRoute.HOME,
        title = R.string.home_title,
        icon = R.drawable.ic_baseline_home
    )
    object History : NavigationScreen(
        route = NavigationRoute.HISTORY,
        title = R.string.history_title,
        icon = R.drawable.ic_baseline_history
    )
    object Settings : NavigationScreen(
        route = NavigationRoute.SETTINGS,
        title = R.string.settings_title,
        icon = R.drawable.ic_baseline_settings
    )
}
