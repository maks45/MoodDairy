package com.my.diary.mood.ui.screen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.my.diary.mood.ui.screen.History
import com.my.diary.mood.ui.screen.Home
import com.my.diary.mood.ui.screen.Settings
import com.my.diary.mood.ui.screen.home.HomeViewModel
import org.koin.java.KoinJavaComponent.get

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationScreen.Home.route.name
    ) {
        composable(route = NavigationScreen.Home.route.name) {
            Home()
        }
        composable(route = NavigationScreen.History.route.name) {
            History()
        }
        composable(route = NavigationScreen.Settings.route.name) {
            Settings()
        }
    }
}