package com.high_thon.lucian.common.icon

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.high_thon.lucian.R

@Composable
fun HomeIcon(
    modifier: Modifier = Modifier,
    isClick: Boolean = false
) {
    if (!isClick) {
        Image(
            painter = painterResource(id = R.drawable.ic_home),
            contentDescription = "Home Icon",
            modifier = modifier
        )
    } else {
        Image(
            painter = painterResource(id = R.drawable.ic_home_color),
            contentDescription = "Home Icon",
            modifier = modifier
        )
    }
}

@Composable
fun CalendarIcon(
    modifier: Modifier = Modifier,
    isClick: Boolean = false
) {
    if (!isClick) {
        Image(
            painter = painterResource(id = R.drawable.ic_calendar),
            contentDescription = "Calendar Icon",
            modifier = modifier
        )
    } else {
        Image(
            painter = painterResource(id = R.drawable.ic_calendar_color),
            contentDescription = "Calendar Icon",
            modifier = modifier
        )
    }
}

@Composable
fun AlarmIcon(
    modifier: Modifier = Modifier,
    isClick: Boolean = false
) {
    if (!isClick) {
        Image(
            painter = painterResource(id = R.drawable.ic_alarm),
            contentDescription = "Alarm Icon",
            modifier = modifier
        )
    } else {
        Image(
            painter = painterResource(id = R.drawable.ic_alarm_color),
            contentDescription = "Alarm Icon",
            modifier = modifier
        )
    }
}

@Composable
fun SettingIcon(
    modifier: Modifier = Modifier,
    isClick: Boolean = false
) {
    if (!isClick) {
        Image(
            painter = painterResource(id = R.drawable.ic_setting),
            contentDescription = "Setting Icon",
            modifier = modifier
        )
    } else {
        Image(
            painter = painterResource(id = R.drawable.ic_setting_color),
            contentDescription = "Setting Icon",
            modifier = modifier
        )
    }
}