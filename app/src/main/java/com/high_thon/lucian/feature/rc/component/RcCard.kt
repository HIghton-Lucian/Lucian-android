package com.high_thon.lucian.feature.rc.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.high_thon.lucian.common.theme.LucianTheme

@Composable
fun RcCard(
    modifier: Modifier,
    text: String,
    enabled: Boolean,
    onDeleteClick: (String) -> Unit
) {
    LucianTheme { colors, typography ->  
        Box(
            modifier = modifier
                .background(Color(0xFF2C3853), RoundedCornerShape(12.dp))
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = text,
                color = colors.WHITE,
                style = typography.B20
            )
            if (enabled) {
                // - 동그라미 {
                Box(modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(20.dp)
                    .offset(
                        x = 12.dp,
                        y = (-8).dp
                    )
                    .background(colors.WHITE, CircleShape)
                    .clickable(
                        enabled = enabled
                    ) {
                        onDeleteClick(text)
                    }
                ) {
                    Box(
                        modifier = Modifier
                            .width(12.dp)
                            .height(2.dp)
                            .background(Color.Red)
                            .align(Alignment.Center)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun RcCardPreview() {
    LucianTheme { _, _ ->
        Column {
            Spacer(modifier = Modifier.height(30.dp))
            RcCard(
                modifier = Modifier
                    .widthIn(min = 232.dp)
                    .fillMaxWidth()
                    .height(78.dp)
                    .padding(horizontal = 64.dp),
                text = "손가락 꺾기",
                enabled = true,
                onDeleteClick = {}
            )
        }
    }
}