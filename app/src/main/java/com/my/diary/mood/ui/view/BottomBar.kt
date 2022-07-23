package com.my.diary.mood.ui.view

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.my.diary.mood.ui.screen.navigation.NavigationScreen

@Composable
fun BottomBar(navHostController: NavHostController) {
    val items = listOf(
        NavigationScreen.Home,
        NavigationScreen.History,
        NavigationScreen.Settings
    )
    val navBackStackEntry = navHostController.currentBackStackEntryAsState()
    val destination = navBackStackEntry.value?.destination

    BottomNavigation {
        items.forEach {
            AddItem(
                screen = it,
                currentDestination = destination,
                navController = navHostController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: NavigationScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(
                text = stringResource(id = screen.title)
            )
        },
        icon = {
            Icon(painter = painterResource(id = screen.icon), contentDescription = "menu item icon")
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route.name
        } == true,
        onClick = {
            navController.navigate(screen.route.name)
        }
    )
}
