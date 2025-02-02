package com.rks.weatherforcast.presentation.screens.favorite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.rks.weatherforcast.presentation.widgets.WeatherAppBar
import com.rks.weatherforcast.ui.theme.WeatherAppLightColors

@Composable
fun FavoriteScreen(navController: NavController) {

    Scaffold(topBar = {
        WeatherAppBar(
            title = "Favorite",
            navController = navController,
            icon = Icons.Default.ArrowBack,
            isMainScreen = false
        ){
            navController.popBackStack()
        }
    }) { paddingValues ->
        ContentFavorite(paddingValues)
    }

}

@Composable
fun ContentFavorite(paddingValues: PaddingValues) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(WeatherAppLightColors.TextSecondary)
        .padding(top = paddingValues.calculateTopPadding())) {




    }
}
