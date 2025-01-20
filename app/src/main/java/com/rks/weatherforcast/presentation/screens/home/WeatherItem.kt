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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rks.weatherforcast.data.model.WeatherItem
import com.rks.weatherforcast.presentation.widgets.CustomText
import com.rks.weatherforcast.ui.theme.WeatherAppLightColors


@Preview
@Composable
fun WeatherItem(
    modifier: Modifier = Modifier,
    item: WeatherItem? = null
) {
    Card(
        modifier = modifier
            .padding(16.dp)
            .height(420.dp)
            .width(200.dp),
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
                    text = "Monday",
                    modifier = modifier,
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                    color = WeatherAppLightColors.TextPrimary
                )

                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(16.dp), horizontalArrangement = Arrangement.Start
                ) {
                    WeatherStateImage(
                        "",
                        modifier
                    )

                    Column {
                        Text(
                            text = "19",
                            modifier = modifier,
                            style = MaterialTheme.typography.headlineLarge,
                            fontWeight = FontWeight.Bold,
                            color = WeatherAppLightColors.TextPrimary
                        )

                        Text(
                            text =
                            "Light Rain",
                            modifier = modifier,
                            style = MaterialTheme.typography.headlineSmall,
                            color = WeatherAppLightColors.TextPrimary
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
                        data = "20"
                    )

                    CustomText(
                        heading =
                        "Min", data = "15"
                    )

                }
                Row(
                    modifier =
                    modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    CustomText(
                        heading = "Feels like",
                        data = "18"
                    )

                    CustomText(
                        heading = "Pressure",
                        data = "1019"
                    )


                }

                Row(
                    modifier =
                    modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    CustomText(
                        heading = "Humidity",
                        data = "90%"
                    )

                    CustomText(
                        heading = "Wind",
                        data = "10 mph"
                    )

                }

            }
        }
    }
}
