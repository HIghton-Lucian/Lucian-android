package com.high_thon.lucian.feature.alarm.component

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.high_thon.lucian.R

@Composable
fun AlarmImage(
    modifier: Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.ic_alarm_image),
        contentDescription = "Setting Icon",
        modifier = modifier
    )
}