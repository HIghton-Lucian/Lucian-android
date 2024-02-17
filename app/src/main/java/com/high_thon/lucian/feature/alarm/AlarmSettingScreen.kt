package com.high_thon.lucian.feature.alarm

import android.content.Context
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.high_thon.lucian.common.theme.LucianTheme
import com.high_thon.lucian.feature.alarm.viewmodel.AlarmViewModel

@Composable
fun AlarmScreen(
    context: Context,
    viewModel: AlarmViewModel,
    navController: NavController
) {
    var isAfternoon by remember { mutableStateOf(false) }
    var hour by remember { mutableStateOf("") }
    var minute by remember { mutableStateOf("") }

    LucianTheme { colors, typography ->
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if(!isAfternoon) "오전" else "오후",
                    modifier = Modifier.clickable {
                        isAfternoon = !isAfternoon
                    },
                    style = typography.B20
                )
                Spacer(modifier = Modifier.width(16.dp))
                TextField(
                    modifier = Modifier.size(100.dp,52.dp),
                    value = hour,
                    onValueChange = {
                        hour = it
                    },
                )
                Spacer(modifier = Modifier.width(16.dp))
                TextField(
                    modifier = Modifier.size(100.dp,52.dp),
                    value = minute,
                    onValueChange = {
                        minute = it
                    },
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                viewModel.setAlarmScheduler(
                    context = context,
                    isAfternoon = isAfternoon,
                    alarmHour = hour.toInt(),
                    alarmMinute = minute.toInt()
                )
            }) {
                Text(text = "알람 등록")
            }
        }
    }
}