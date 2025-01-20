package com.rks.weatherforcast.presentation.widgets

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter

@Composable
fun WeatherImage(imageUrl: String, modifier: Modifier = Modifier) {
    Log.i("AsyncImage", imageUrl)
    Image(
    painter = rememberAsyncImagePainter(imageUrl),
    contentDescription = "Weather Icon",
    modifier = modifier
    .size(80.dp)
    )
}