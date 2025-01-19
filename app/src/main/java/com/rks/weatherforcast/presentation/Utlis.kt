package com.rks.weatherforcast.presentation

import java.text.SimpleDateFormat
import java.util.Date
import kotlin.contracts.CallsInPlace

fun formatDate(timeStamp: Int): String{
    val sdf = SimpleDateFormat("EEE, MMM d")
    val date = Date(timeStamp.toLong() * 1000)

    return sdf.format(date)
}
fun formatTime(timeStamp: Int): String{
    val sdf = SimpleDateFormat("hh:mm:aa")
    val date = Date(timeStamp.toLong() * 1000)

    return sdf.format(date)
}



fun formatDecimals(item: Double): String{
    return " %.0f".format(item)
}