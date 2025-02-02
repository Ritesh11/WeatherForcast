package com.rks.weatherforcast.presentation.screens.about

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
fun AboutScreen(navController: NavController) {

    Scaffold(topBar = {
        WeatherAppBar(
            title = "About",
            navController = navController,
            icon = Icons.Default.ArrowBack,
            isMainScreen = false
        ){
            navController.popBackStack()
        }
    }) { paddingValues ->
        ContentAbout(paddingValues)
    }

}

@Composable
fun ContentAbout(paddingValues: PaddingValues) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(WeatherAppLightColors.TextSecondary)
            .padding(top = paddingValues.calculateTopPadding())
    ) {


    }
}
