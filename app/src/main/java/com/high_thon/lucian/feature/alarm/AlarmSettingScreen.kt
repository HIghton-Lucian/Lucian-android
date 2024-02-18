package com.high_thon.lucian.feature.alarm

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.high_thon.lucian.R
import com.high_thon.lucian.common.theme.LucianTheme
import com.high_thon.lucian.feature.alarm.viewmodel.AlarmViewModel

@Composable
fun AlarmSettingScreen(
    context: Context,
    viewModel: AlarmViewModel,
    navController: NavController,
    onClick: () -> Unit
) {
    var isAfternoon by remember { mutableStateOf(false) }
    var hour by remember { mutableStateOf("") }
    var minute by remember { mutableStateOf("") }

    LucianTheme { colors, typography ->
        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_al_1),
                contentDescription = "Setting Icon",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        onClick()
                    }
            )

        }
    }
}

@Composable
fun Alarm1(
    onClick: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.ic_al_1),
            contentDescription = "Setting Icon",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    onClick()
                }
        )
    }
}

@Composable
fun Alarm2(
    onClick: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.ic_al_2),
            contentDescription = "Setting Icon",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    onClick()
                }
        )
    }
}

@Composable
fun Alarm3(
    onClick: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.ic_al_3),
            contentDescription = "Setting Icon",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    onClick()
                }
        )
    }
}

@Composable
fun Alarm4(
    onClick: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.ic_al_4),
            contentDescription = "Setting Icon",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    onClick()
                }
        )
    }
}