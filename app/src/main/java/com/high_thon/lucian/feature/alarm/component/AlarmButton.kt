package com.high_thon.lucian.feature.alarm.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.high_thon.lucian.common.theme.LucianTheme

@Composable
fun AlarmButton(
    isWriteDiary: Boolean,
    onClick: () -> Unit
) {
    LucianTheme { colors, typography ->
        Button(
            modifier = Modifier.size(314.dp,60.dp),
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(colors.LIGHTBLUE2),
            onClick = { onClick() }
        ) {
            if(isWriteDiary) {
                Text(
                    text = "작성",
                    style = typography.B20,
                    color = colors.WHITE,
                    fontWeight = FontWeight.ExtraBold
                )
            } else {
                Text(
                    text = "알람끄기",
                    style = typography.B20,
                    color = colors.WHITE,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }
    }
}