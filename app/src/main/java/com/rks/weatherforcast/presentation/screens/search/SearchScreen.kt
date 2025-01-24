package com.rks.weatherforcast.presentation.screens.search

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBarColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.rks.weatherforcast.presentation.nav.WeatherScreens
import com.rks.weatherforcast.presentation.widgets.WeatherAppBar
import com.rks.weatherforcast.ui.theme.WeatherAppLightColors

@Composable
fun SearchScreen(navController: NavController) {

    Scaffold(
        topBar = {
            WeatherAppBar(
                title = "Search",
                navController = navController,
                icon = Icons.Default.ArrowBack,
                isMainScreen = false,
            ) {
                navController.popBackStack()
            }
        }
    ) { padding ->
        Content(padding, navController)
    }
}

@Composable
fun Content(padding: PaddingValues,
            navController: NavController) {
    Column(modifier = Modifier
        .padding(top = padding.calculateTopPadding())
        .background(WeatherAppLightColors.TextSecondary)
        .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SearchBar(modifier = Modifier
            .fillMaxWidth()
            .padding(padding)
            .align(Alignment.CenterHorizontally)){ city ->
            navController.navigate(WeatherScreens.HomeScreen.name+"/$city"){
                navController.popBackStack()
            }
        }
    }
}


@Composable
fun SearchBar(modifier: Modifier = Modifier,
              onSearch: (String) -> Unit = {}) {
    val searchQueryState = rememberSaveable() {
        mutableStateOf("")
    }

    val keyboardController = LocalSoftwareKeyboardController.current
    val valid = remember(searchQueryState.value) {
        searchQueryState.value.trim().isNotEmpty()
    }

    Column() {
        CommonTextField(
            valueState = searchQueryState,
            placeHolder = "City Name",
            onAction = KeyboardActions {
                if(!valid) return@KeyboardActions
                onSearch(searchQueryState.value.trim())
                searchQueryState.value = ""
                keyboardController?.hide()
            }
        )
    }

}

@Composable
fun CommonTextField(
    valueState: MutableState<String>,
    placeHolder: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Default,
    onAction: KeyboardActions = KeyboardActions.Default
) {

    OutlinedTextField(
        value = valueState.value,
        onValueChange = { valueState.value = it },
        label = { Text(text = placeHolder) },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = onAction,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = WeatherAppLightColors.lightSkyBlueColor,
            unfocusedBorderColor = WeatherAppLightColors.TextPrimary,
            cursorColor = WeatherAppLightColors.TextPrimary,
            focusedTextColor = WeatherAppLightColors.TextPrimary
        ),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    )

}
