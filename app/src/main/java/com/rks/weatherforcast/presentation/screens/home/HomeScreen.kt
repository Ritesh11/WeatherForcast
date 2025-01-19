package com.rks.weatherforcast.presentation.screens.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.rks.weatherforcast.data.model.Weather
import com.rks.weatherforcast.data.wrapper.DataOrException
import com.rks.weatherforcast.presentation.widgets.WeatherAppBar

@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {

    val weatherData = produceState<DataOrException<Weather, Boolean, Exception>>(
        initialValue = DataOrException(loading = true)
    ) {
        value = homeViewModel.getWeatherData(city = "Bengaluru")
    }.value



    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (weatherData.loading == true) {
            CircularProgressIndicator()
        } else if (weatherData.data != null) {
            ShowWeatherData(
                weather = weatherData.data!!,
                modifier = modifier,
                navController = navController
            );
        }
    }
}

@SuppressLint("ProduceStateDoesNotAssignValue")
@Composable
fun ShowWeatherData(
    weather: Weather,
    modifier: Modifier = Modifier,
    navController: NavController
) {

    Scaffold(modifier = modifier, topBar = {
            WeatherAppBar(title = weather.city.name +", ${weather.city.country}"
                , navController = navController){
                Log.i("Weather App","Button Clicked")
            }
        }){ padding ->
        MainContent(weather,
            modifier.padding(padding))
    }

}

@Composable
fun MainContent(weather: Weather?, modifier: Modifier = Modifier){
    Text(text = weather?.city?.country!!)
}