package com.high_thon.lucian.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.high_thon.lucian.common.theme.LucianTheme


@Composable
fun HomeScreen(

) {
    LucianTheme { colors, typography ->  
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colors.BACKGROUND)
        ) {
            Spacer(modifier = Modifier.height(33.dp))
            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = "좋은 아침이에요",
                color = colors.GRAY4,
                style = typography.B14
            )
            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = "SAEHYUN",
                color = colors.WHITE,
                style = typography.B20
            )
            Spacer(modifier = Modifier.height(31.dp))

        }
    }
}