package com.rks.weatherforcast.data.network

import com.rks.weatherforcast.BuildConfig
import com.rks.weatherforcast.data.model.Weather
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface WeatherService {

    @GET(value = "data/2.5/forecast/daily")
    suspend fun getWeatherReport(
        @Query("q") query: String,
        @Query("units") units: String = "metric",
        @Query("appid") appid: String = BuildConfig.API_KEY,
    ): Weather
}