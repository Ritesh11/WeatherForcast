package com.rks.weatherforcast.presentation.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.rks.weatherforcast.presentation.screens.about.AboutScreen
import com.rks.weatherforcast.presentation.screens.favorite.FavoriteScreen
import com.rks.weatherforcast.presentation.screens.splash.SplashScreen
import com.rks.weatherforcast.presentation.screens.home.HomeScreen
import com.rks.weatherforcast.presentation.screens.home.HomeViewModel
import com.rks.weatherforcast.presentation.screens.search.SearchScreen
import com.rks.weatherforcast.presentation.screens.setting.SettingScreen

@Composable
fun AppNavHost(modifier: Modifier = Modifier) {

    val _NavController = rememberNavController()

    NavHost(
        navController = _NavController,
        startDestination = WeatherScreens.SplashScreen.name
    ) {

        val home = WeatherScreens.HomeScreen.name

        composable(WeatherScreens.SplashScreen.name) {
            SplashScreen(navController = _NavController)
        }

        composable(WeatherScreens.SearchScreen.name) {
            SearchScreen(navController = _NavController)
        }

        composable(
            "$home/{city}",
            arguments = listOf(
                navArgument(name = "city") {
                    type = NavType.StringType
                })
        ) { backStackEntry ->
            backStackEntry.arguments?.getString("city").let { city ->

                val homeViewModel = hiltViewModel<HomeViewModel>()
                HomeScreen(
                    navController = _NavController,
                    homeViewModel = homeViewModel,
                    city = city
                )
            }
        }

        composable(WeatherScreens.AboutScreen.name) {
            AboutScreen(navController = _NavController)
        }

        composable(WeatherScreens.FavoriteScreen.name) {
            FavoriteScreen(navController = _NavController)
        }

        composable(WeatherScreens.SettingScreen.name) {
            SettingScreen(navController = _NavController)
        }
    }
}