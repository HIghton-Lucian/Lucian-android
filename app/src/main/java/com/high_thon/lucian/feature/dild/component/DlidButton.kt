package com.high_thon.lucian.feature.dild.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.high_thon.lucian.R
import com.high_thon.lucian.common.theme.LucianTheme
import com.high_thon.lucian.feature.home.component.HomeButton

@Composable
fun DildButton(
    modifier: Modifier,
    text: String
) {
    LucianTheme { colors, typography ->
        Box(
            modifier = modifier
                .then(
                    Modifier.background(
                        color = Color(0xFF41495B),
                        shape = RoundedCornerShape(15.dp)
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Box {
                Text(
                    modifier = Modifier.padding(vertical = 14.dp),
                    text = text,
                    color = colors.WHITE,
                    style = typography.B20
                )
            }
        }
    }
}

@Preview
@Composable
private fun DildButtonPreview() {
    LucianTheme { colors, typography ->
        DildButton(
            modifier = Modifier
                .fillMaxWidth(),
            text = "수면하기"
        )
    }
}