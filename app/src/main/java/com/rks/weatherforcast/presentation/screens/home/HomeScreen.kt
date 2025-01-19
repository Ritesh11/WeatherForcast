package com.rks.weatherforcast.presentation.screens.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.rks.weatherforcast.R
import com.rks.weatherforcast.data.model.Weather
import com.rks.weatherforcast.data.wrapper.DataOrException
import com.rks.weatherforcast.presentation.widgets.WeatherAppBar
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
            modifier.padding(padding)
        )
    }

}

@Preview
@Composable
fun MainContent(
    weather: Weather? = null,
    modifier: Modifier = Modifier
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
            text = "Mon, Nov 29",
            modifier = modifier
                .padding(top = 16.dp, bottom = 16.dp),
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = WeatherAppLightColors.TextPrimary
            )
        )

        TopCircle(modifier)
        Spacer(modifier = modifier.padding(top = 16.dp))
        HumidityRow(modifier)
        Spacer(modifier = modifier.padding(top = 16.dp))
        SunRiseRow(modifier)

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

    }


}


@Composable
fun TopCircle(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        shape = CircleShape,
        color = WeatherAppLightColors.CircleContainer
    ) {

        Column(
            modifier = modifier
                .size(200.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(R.drawable.cloudy),
                contentDescription = "Weather Icon",
                modifier = modifier
                    .size(50.dp)
            )

            Spacer(
                modifier = modifier
                    .size(30.dp)
            )

            Text(
                text = "54",
                style = TextStyle(
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Text(
                text = "Rain",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontStyle = FontStyle.Italic
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
                .size(20.dp)
        )
        Spacer(modifier = Modifier.width(2.dp))
        Text(
            text = humidity,
            modifier = modifier,
            style = TextStyle(
                fontSize = 16.sp
            )
        )
    }
}