package com.raithavartha.app.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AppDestination(val route: String) {
    data object Login : AppDestination("login")
    data object Home : AppDestination("home")
    data object Search : AppDestination("search")
    data object Expert : AppDestination("expert")
    data object Saved : AppDestination("saved")
    data object Profile : AppDestination("profile")
    data object Detail : AppDestination("detail/{advisoryId}") {
        fun createRoute(advisoryId: Int) = "detail/$advisoryId"
    }
}

data class BottomNavItem(
    val route: String,
    val label: String,
    val icon: ImageVector
)

val bottomNavItems = listOf(
    BottomNavItem(AppDestination.Home.route, "Home", Icons.Filled.Home),
    BottomNavItem(AppDestination.Search.route, "Search", Icons.Filled.Search),
    BottomNavItem(AppDestination.Expert.route, "Expert", Icons.Filled.CameraAlt),
    BottomNavItem(AppDestination.Saved.route, "Saved", Icons.Filled.Bookmark),
    BottomNavItem(AppDestination.Profile.route, "Profile", Icons.Filled.Person)
)
