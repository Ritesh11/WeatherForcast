package com.rks.weatherforcast.module

import android.util.Log
import com.rks.weatherforcast.data.model.Weather
import com.rks.weatherforcast.data.network.WeatherService
import com.rks.weatherforcast.data.wrapper.DataOrException
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api : WeatherService) {


    suspend fun getWeatherReport(cityQuery: String): DataOrException<Weather, Boolean, Exception> {

        val response = try{
            api.getWeatherReport(cityQuery)
        }catch (e: Exception){
            Log.d("INSIDE","getWeather: $e")
            return DataOrException(e= e)
        }
        Log.d("INSIDE","getWeather: $response")
        return DataOrException(data = response)
    }
}