package com.rks.weatherforcast.presentation.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.rks.weatherforcast.R
import com.rks.weatherforcast.ui.theme.WeatherAppLightColors

@Composable
fun WeatherDropDownItems(text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            imageVector = when (text) {
                stringResource(R.string.option_about) -> Icons.Default.Info
                stringResource(R.string.option_favorites) -> Icons.Default.FavoriteBorder
                stringResource(R.string.option_settings) -> Icons.Default.Settings
                else -> Icons.Default.AccountBox
            },
            contentDescription = text,
            tint = WeatherAppLightColors.TextPrimary
        )

        Spacer(modifier = Modifier.width(5.dp))

        Text(
            text = text,
            color = WeatherAppLightColors.TextPrimary,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}