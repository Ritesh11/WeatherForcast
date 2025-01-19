package com.rks.weatherforcast.data.model

data class WeatherObject(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)