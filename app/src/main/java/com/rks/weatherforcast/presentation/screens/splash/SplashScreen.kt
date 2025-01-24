package com.rks.weatherforcast.presentation.screens.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.rks.weatherforcast.R
import com.rks.weatherforcast.presentation.nav.WeatherScreens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController, modifier: Modifier = Modifier) {

    val scale = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = true, block = {
        scale.animateTo(targetValue = 0.9f,
            animationSpec = tween(durationMillis = 800,
                easing = { OvershootInterpolator(8f).getInterpolation(it) }
            ))

        delay(1000L)
        navController.navigate(WeatherScreens.HomeScreen.name+"/Bengaluru"){
            popUpTo(WeatherScreens.SplashScreen.name){
                inclusive = true
            }
        }
    })

    Box(
        modifier = modifier
            .fillMaxSize()
            .scale(scale.value)
    ) {

        Image(
            painter = painterResource(R.drawable.weather_news),
            contentDescription = "Chatak Logo",
            modifier = modifier
                .align(Alignment.Center)
                .height(100.dp)
                .width(200.dp)
        )

        Text(
            text = "Version 1.0.0",
            modifier = modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            fontSize = 12.sp,
            color = Color.Blue

        )

    }


}