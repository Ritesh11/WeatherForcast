package com.rks.weatherforcast.presentation.screens.home

import androidx.lifecycle.ViewModel
import com.rks.weatherforcast.data.model.Weather
import com.rks.weatherforcast.data.wrapper.DataOrException
import com.rks.weatherforcast.module.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: WeatherRepository): ViewModel() {

    suspend fun getWeatherData(city: String): DataOrException<Weather, Boolean, Exception>{
        return repository.getWeatherReport(cityQuery = city)
    }
}