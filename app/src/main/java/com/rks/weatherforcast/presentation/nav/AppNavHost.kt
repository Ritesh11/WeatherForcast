package com.rks.weatherforcast.presentation.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rks.weatherforcast.presentation.screens.splash.SplashScreen
import com.rks.weatherforcast.presentation.screens.home.HomeScreen
import com.rks.weatherforcast.presentation.screens.home.HomeViewModel

@Composable
fun AppNavHost(modifier: Modifier = Modifier) {

    val _NavController = rememberNavController()

    NavHost(
        navController = _NavController,
        startDestination = AppNavigation.SplashScreen.name
    ) {

        composable(AppNavigation.SplashScreen.name) {
            SplashScreen(navController = _NavController)
        }

        composable(AppNavigation.HomeScreen.name) {
            val homeViewModel = hiltViewModel<HomeViewModel>()
            HomeScreen(navController = _NavController, homeViewModel = homeViewModel)
        }
    }
}