package com.rks.weatherforcast.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rks.weatherforcast.data.model.WeatherItem
import com.rks.weatherforcast.presentation.formatDay
import com.rks.weatherforcast.presentation.formatDecimals
import com.rks.weatherforcast.presentation.widgets.CustomText
import com.rks.weatherforcast.presentation.widgets.WeatherImage
import com.rks.weatherforcast.ui.theme.WeatherAppLightColors


@Composable
fun WeatherItem(
    modifier: Modifier = Modifier,
    item: WeatherItem
) {
    val imageUrl = "https://openweathermap.org/img/wn/${item.weather[0].icon}.png"
    Card(
        modifier = modifier
            .padding(5.dp)
            .height(205.dp)
            .width(150.dp),
        shape = RoundedCornerShape(2.dp),
        elevation = CardDefaults.cardElevation(5.dp),
        colors = CardDefaults.cardColors(containerColor = WeatherAppLightColors.CardBlueColor),
    ) {
        Box(modifier = modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "${formatDay(item.dt)}",
                    modifier = modifier,
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                    color = WeatherAppLightColors.TextPrimary
                )

                Row(
                    modifier = modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    WeatherImage(
                        imageUrl,
                        modifier
                    )

                    Column {
                        Text(
                            text = "${formatDecimals(item.temp.day)}",
                            modifier = modifier,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold,
                            color = WeatherAppLightColors.TextPrimary,
                            maxLines = 1
                        )

                        Text(
                            text = "${item.weather[0].description}",
                            modifier = modifier,
                            style = MaterialTheme.typography.bodySmall,
                            color = WeatherAppLightColors.TextPrimary,
                            maxLines = 2
                        )
                    }
                }

                Row(
                    modifier =
                    modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    CustomText(
                        heading = "Max",
                        data = "${formatDecimals(item.temp.max)}"
                    )

                    CustomText(
                        heading =
                        "Min", data = "${formatDecimals(item.temp.min)}"
                    )

                    CustomText(
                        heading = "Wind",
                        data = "${item.speed}"
                    )

                }
                Row(
                    modifier =
                    modifier.fillMaxWidth()
                        .padding(top = 10.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    CustomText(
                        heading = "Humidity",
                        data = "${item.humidity}%"
                    )

                    CustomText(
                        heading = "Pressure",
                        data = "${item.pressure}"
                    )


                }

            }
        }
    }
}
