package com.rks.weatherforcast.presentation.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.rks.weatherforcast.ui.theme.WeatherAppLightColors

@Preview
@Composable
fun CustomText(heading: String = "Max", data: String = "20") {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = heading,
            style = MaterialTheme.typography.bodySmall,
            color = WeatherAppLightColors.TextPrimary
        )

        Text(
            text = data,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Bold,
            color = WeatherAppLightColors.TextPrimary
        )
    }
}