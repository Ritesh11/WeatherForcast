package com.rks.weatherforcast.presentation.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.rks.weatherforcast.ui.theme.WeatherAppLightColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherAppBar(
    title: String = "Title",
    icon: ImageVector? = null,
    isMainScreen: Boolean = true,
    elevation: Dp = 5.dp,
    navController: NavController? = null,
    onAddActionClicked: () -> Unit = {},
    onButtonClicked: () -> Unit = {}
) {

    val showDialog = remember {
        mutableStateOf(false)
    }

    if (showDialog.value) {
        ShowSettingDropDownValue(
            showDialog = showDialog,
            navController = navController
        )
    }

    TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
        containerColor = WeatherAppLightColors.lightSkyBlueColor,
        titleContentColor = WeatherAppLightColors.TextSecondary
    ),
        title = {
            Text(
                text = title,
                color = WeatherAppLightColors.TextSecondary,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
            )
        },
        navigationIcon = {
            if (icon != null) {
                Icon(
                    imageVector = icon, contentDescription = "",
                    tint = WeatherAppLightColors.TextSecondary,
                    modifier = Modifier.clickable {
                        onButtonClicked.invoke()
                    }
                )
            }
        },
        actions = {
            if (isMainScreen) {
                IconButton(onClick = {
                    onAddActionClicked.invoke()
                }) {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = "Search",
                        tint = Color.White
                    )
                }

                IconButton(onClick = {
                    showDialog.value = showDialog.value.not()
                }) {
                    Icon(
                        Icons.Default.MoreVert,
                        contentDescription = "More Options",
                        tint = Color.White
                    )
                }
            } else {
                Box { }
            }
        }
    )

}

@Composable
fun ShowSettingDropDownValue(
    showDialog: MutableState<Boolean>,
    navController: NavController? = null
) {


    val item = listOf("About", "Favorites", "Settings")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize()
            .absolutePadding(top = 45.dp, right = 20.dp)
    ) {

        DropdownMenu(
            expanded = showDialog.value,
            onDismissRequest = {
                showDialog.value = false},
            modifier = Modifier
                .width(140.dp)
                .background(WeatherAppLightColors.TextSecondary)
        ) {

            item.forEachIndexed { index, text ->
                DropdownMenuItem(text = {
                    WeatherDropDownItems(text)
                },onClick = {
                    showDialog.value = false
                })
            }

        }

    }

}
