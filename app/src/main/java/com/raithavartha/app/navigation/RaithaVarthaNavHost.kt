package com.raithavartha.app.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.raithavartha.app.screens.AdvisoryDetailScreen
import com.raithavartha.app.screens.AskExpertScreen
import com.raithavartha.app.screens.HomeScreen
import com.raithavartha.app.screens.LoginScreen
import com.raithavartha.app.screens.ProfileScreen
import com.raithavartha.app.screens.SavedTipsScreen
import com.raithavartha.app.screens.SearchScreen
import com.raithavartha.app.ui.theme.Cream
import com.raithavartha.app.ui.theme.LeafGreen
import com.raithavartha.app.ui.theme.SunYellow
import com.raithavartha.app.viewmodel.RaithaVarthaViewModel

@Composable
fun RaithaVarthaNavHost(
    viewModel: RaithaVarthaViewModel,
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val showBottomBar = currentRoute in bottomNavItems.map { it.route }

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                RaithaBottomNavigation(navController = navController)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AppDestination.Login.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(AppDestination.Login.route) {
                LoginScreen(
                    onLogin = { name ->
                        viewModel.login(name)
                        navController.navigate(AppDestination.Home.route) {
                            popUpTo(AppDestination.Login.route) { inclusive = true }
                        }
                    }
                )
            }
            composable(AppDestination.Home.route) {
                HomeScreen(
                    viewModel = viewModel,
                    onOpenDetail = { navController.navigate(AppDestination.Detail.createRoute(it)) },
                    onOpenSearch = { navController.navigate(AppDestination.Search.route) }
                )
            }
            composable(AppDestination.Search.route) {
                SearchScreen(
                    viewModel = viewModel,
                    onOpenDetail = { navController.navigate(AppDestination.Detail.createRoute(it)) }
                )
            }
            composable(AppDestination.Expert.route) {
                AskExpertScreen(viewModel = viewModel)
            }
            composable(AppDestination.Saved.route) {
                SavedTipsScreen(
                    viewModel = viewModel,
                    onOpenDetail = { navController.navigate(AppDestination.Detail.createRoute(it)) }
                )
            }
            composable(AppDestination.Profile.route) {
                ProfileScreen(
                    viewModel = viewModel,
                    onLogout = {
                        navController.navigate(AppDestination.Login.route) {
                            popUpTo(AppDestination.Home.route) { inclusive = true }
                        }
                    }
                )
            }
            composable(
                route = AppDestination.Detail.route,
                arguments = listOf(navArgument("advisoryId") { type = NavType.IntType })
            ) { entry ->
                val advisoryId = entry.arguments?.getInt("advisoryId") ?: return@composable
                AdvisoryDetailScreen(
                    advisory = viewModel.advisoryById(advisoryId),
                    isSaved = viewModel.isSaved(advisoryId),
                    onBack = { navController.popBackStack() },
                    onSave = { viewModel.toggleSaved(advisoryId) }
                )
            }
        }
    }
}

@Composable
private fun RaithaBottomNavigation(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(containerColor = Cream) {
        bottomNavItems.forEach { item ->
            val selected = currentDestination?.hierarchy?.any { it.route == item.route } == true
            NavigationBarItem(
                selected = selected,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(AppDestination.Home.route) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = LeafGreen,
                    selectedTextColor = LeafGreen,
                    indicatorColor = SunYellow.copy(alpha = 0.28f)
                )
            )
        }
    }
}
