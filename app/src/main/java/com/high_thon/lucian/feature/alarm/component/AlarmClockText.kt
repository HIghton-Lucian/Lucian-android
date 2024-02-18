package com.high_thon.lucian.feature.alarm.component

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import com.high_thon.lucian.common.theme.LucianTheme

@Composable
fun AlarmClockText(
    hour: String,
    minute: String
) {
    LucianTheme { colors, typography ->
        Text(
            text = "$hour  :  $minute",
            style = typography.Clock,
            color = colors.WHITE
            )
    }
}