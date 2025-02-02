package com.rks.weatherforcast.presentation.screens.setting

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
fun SettingScreen(navController: NavController) {
    Scaffold(topBar = {
        WeatherAppBar(
            title = "Favorite",
            navController = navController,
            icon = Icons.Default.ArrowBack,
            isMainScreen = false
        ) {
            navController.popBackStack()
        }
    }) { paddingValues ->
        ContentSetting(paddingValues)
    }

}

@Composable
fun ContentSetting(paddingValues: PaddingValues) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = paddingValues.calculateTopPadding())
            .background(WeatherAppLightColors.TextSecondary)
    ) {


    }
}
