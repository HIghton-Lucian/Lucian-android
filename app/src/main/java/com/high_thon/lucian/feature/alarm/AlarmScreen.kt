package com.high_thon.lucian.feature.alarm

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.high_thon.lucian.common.theme.LucianTheme
import com.high_thon.lucian.feature.alarm.component.AlarmButton
import com.high_thon.lucian.feature.alarm.component.AlarmClockText
import com.high_thon.lucian.feature.alarm.component.AlarmImage

@Composable
fun AlarmScreen(
    onClick: () -> Unit
) {
    LucianTheme { colors, typography ->  
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colors.BACKGROUND)
                .padding(top = 104.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AlarmClockText(hour = "6", minute = "25")
            Spacer(modifier = Modifier.height(68.dp))
            AlarmImage(modifier = Modifier.size(285.dp, 390.dp))
            Spacer(modifier = Modifier.height(104.dp))
            AlarmButton(isWriteDiary = true) {
               onClick()
           } 
        }
    }
}