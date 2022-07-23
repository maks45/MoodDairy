package com.my.diary.mood.ui.screen

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.my.diary.mood.ui.screen.navigation.BottomNavGraph
import com.my.diary.mood.ui.view.BottomBar

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomBar(navHostController = navController)
        }
    ) {
        BottomNavGraph(navController = navController)
    }
}
