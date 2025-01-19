package com.rks.weatherforcast.presentation.screens.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rks.weatherforcast.presentation.nav.AppNavHost
import com.rks.weatherforcast.ui.theme.WeatherForcastTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherForcastTheme {
                WeatherApp()
            }
        }
    }
}

@Composable
fun WeatherApp(modifier: Modifier = Modifier) {
    AppNavHost(modifier)
}