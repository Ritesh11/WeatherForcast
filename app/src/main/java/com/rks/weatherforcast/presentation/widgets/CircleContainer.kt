package com.rks.weatherforcast.presentation.widgets

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import com.rks.weatherforcast.ui.theme.WeatherAppLightColors

@Composable
fun CircleContainer(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Canvas(
        modifier = modifier
            .size(300.dp) // Adjust size as needed
    ) {
        drawCircle(
            color = WeatherAppLightColors.CircleContainer,
            radius = size.minDimension / 2f,
            center = Offset(size.width / 2f, size.height / 2f)
        )
    }

    content()
}