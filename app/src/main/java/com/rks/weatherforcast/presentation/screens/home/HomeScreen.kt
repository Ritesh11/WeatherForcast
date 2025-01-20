package com.rks.weatherforcast.presentation.screens.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil3.compose.rememberAsyncImagePainter
import com.rks.weatherforcast.R
import com.rks.weatherforcast.data.model.Weather
import com.rks.weatherforcast.data.wrapper.DataOrException
import com.rks.weatherforcast.presentation.formatDate
import com.rks.weatherforcast.presentation.formatDecimals
import com.rks.weatherforcast.presentation.formatTime
import com.rks.weatherforcast.presentation.widgets.WeatherAppBar
import com.rks.weatherforcast.presentation.widgets.WeatherImage
import com.rks.weatherforcast.ui.theme.WeatherAppLightColors

@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {

    val weatherData = produceState<DataOrException<Weather, Boolean, Exception>>(
        initialValue = DataOrException(loading = true)
    ) {
        value = homeViewModel.getWeatherData(city = "Bengaluru")
    }.value



    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (weatherData.loading == true) {
            CircularProgressIndicator()
        } else if (weatherData.data != null) {
            ShowWeatherData(
                weather = weatherData.data!!,
                modifier = modifier,
                navController = navController
            );
        }
    }
}

@SuppressLint("ProduceStateDoesNotAssignValue")
@Composable
fun ShowWeatherData(
    weather: Weather,
    modifier: Modifier = Modifier,
    navController: NavController
) {

    Scaffold(modifier = modifier,
        topBar = {
            WeatherAppBar(
                title = weather.city.name + ", ${weather.city.country}",
                navController = navController
            ) {
                Log.i("Weather App", "Button Clicked")
            }
        }) { padding ->
        MainContent(
            weather,
            padding,
            modifier
        )
    }

}


@Composable
fun MainContent(
    weather: Weather,
    paddingValue: PaddingValues,
    modifier: Modifier = Modifier
) {

    val data = weather.list[0]
    Box(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = paddingValue.calculateTopPadding())
            .background(WeatherAppLightColors.TextSecondary)
    ) {

        Column(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(start = 16.dp, end = 16.dp)
                .background(WeatherAppLightColors.TextSecondary),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "${formatDate(weather.list[0].dt)}",
                modifier = modifier
                    .padding(top = 16.dp, bottom = 16.dp),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = WeatherAppLightColors.TextPrimary
                )
            )

            TopCircle(modifier, weather)
            Spacer(modifier = modifier.padding(top = 16.dp))
            HumidityRow(
                modifier, humidity = "${data.humidity}",
                psi = "${data.pressure} psi",
                windSpeed = "${data.speed} mhp"
            )
            Spacer(modifier = modifier.padding(top = 10.dp))
            Divider()
            Spacer(modifier = modifier.padding(top = 10.dp))
            SunRiseRow(
                modifier, sunRise = "${formatTime(data.sunrise)}",
                sunSet = "${formatTime(data.sunset)}"
            )

            Text(
                text = "This Week",
                modifier = modifier
                    .padding(top = 16.dp, bottom = 16.dp),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = WeatherAppLightColors.TextPrimary
                )
            )

            LazyVerticalGrid(
                modifier = modifier
                    .fillMaxWidth(),
                columns = GridCells.Fixed(1),
            ) {

                items(weather.list) { item ->

                    WeatherItem(item = item)

                }

            }

        }
    }

}

@Composable
fun TopCircle(modifier: Modifier = Modifier, weather: Weather) {
    val imageUrl = "https://openweathermap.org/img/wn/${weather.list[0].weather[0].icon}.png"
    Surface(
        modifier = modifier
            .size(200.dp),
        shape = CircleShape,
        color = WeatherAppLightColors.CircleContainer
    ) {

        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            WeatherImage(imageUrl = imageUrl, modifier = modifier)

            Spacer(
                modifier = modifier
                    .size(10.dp)
            )

            Text(
                text = formatDecimals(weather.list[0].temp.day) + "",
                style = TextStyle(
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    color = WeatherAppLightColors.TextPrimary
                )
            )

            Text(
                text = weather.list[0].weather[0].description,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontStyle = FontStyle.Italic,
                    color = WeatherAppLightColors.TextPrimary
                )
            )

        }
    }
}

@Composable
fun HumidityRow(
    modifier: Modifier = Modifier,
    humidity: String = "90%",
    psi: String = "1024 psi",
    windSpeed: String = "8 mph"
) {

    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        WeatherDetailItem(modifier, humidity, R.drawable.humidity)
        WeatherDetailItem(modifier, psi, R.drawable.pressure)
        WeatherDetailItem(modifier, windSpeed, R.drawable.wind)
    }

}


@Composable
fun SunRiseRow(
    modifier: Modifier = Modifier,
    sunRise: String = "11:34 AM",
    sunSet: String = "08:21 PM"
) {

    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        WeatherDetailItem(modifier, sunRise, R.drawable.sunrise)
        WeatherDetailItem(modifier, sunSet, R.drawable.sunset)
    }

}

@Composable
fun WeatherDetailItem(modifier: Modifier, humidity: String, imageResource: Int) {
    Row(
        modifier = modifier
    ) {
        Icon(
            painter = painterResource(imageResource),
            contentDescription = "Humidity",
            modifier = modifier
                .size(20.dp),
            tint = WeatherAppLightColors.TextPrimary
        )
        Spacer(modifier = Modifier.width(2.dp))
        Text(
            text = humidity,
            modifier = modifier,
            style = TextStyle(
                fontSize = 16.sp
            ),
            color = WeatherAppLightColors.TextPrimary
        )
    }
}
