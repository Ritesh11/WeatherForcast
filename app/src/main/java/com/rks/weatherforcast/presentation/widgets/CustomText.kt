package com.rks.weatherforcast.presentation.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rks.weatherforcast.ui.theme.WeatherAppLightColors


@Composable
fun CustomText(heading: String = "Max", data: String = "20") {
    val annotatedString = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = 16.sp,
                color = WeatherAppLightColors.TextPrimary
            )
        ) { append(heading + "\n") }

        withStyle(
            style =
            SpanStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp)
        ) { append(data) }
    }

    Box {
        Text(
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.Center),
            text = annotatedString,
            style = MaterialTheme.typography.headlineSmall,
            color = WeatherAppLightColors.TextPrimary
        )
    }
}