package com.rks.weatherforcast.presentation.screens.home

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rks.weatherforcast.data.model.Weather
import com.rks.weatherforcast.data.wrapper.DataOrException
import com.rks.weatherforcast.module.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: WeatherRepository): ViewModel() {

    /*val data : MutableState<DataOrException<Weather, Boolean, Exception>> =
        mutableStateOf(DataOrException(null, true, Exception("")))

    init {
        loadWeather("Bengaluru")
    }


    fun loadWeather(city: String){
        viewModelScope.launch {
            if(city.isEmpty()) return@launch

            data.value.loading = true
            data.value = repository.getWeatherReport(city)
            if (data.value.data.toString().isNotEmpty()) data.value.loading = false


        }

        Log.d("GET","getWeather: ${data.value.data.toString()}")
    }*/


    suspend fun getWeatherData(city: String): DataOrException<Weather, Boolean, Exception>{
        return repository.getWeatherReport(cityQuery = city)
    }
}