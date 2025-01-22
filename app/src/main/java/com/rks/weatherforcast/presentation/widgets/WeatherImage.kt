package com.rks.weatherforcast.presentation.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter

@Composable
fun WeatherImage(imageUrl: String,
                 size: Dp,
                 modifier: Modifier = Modifier) {
    Image(
    painter = rememberAsyncImagePainter(imageUrl),
    contentDescription = "Weather Icon",
    modifier = modifier
    .size(size)
    )
}