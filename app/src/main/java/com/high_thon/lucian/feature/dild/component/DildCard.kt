package com.high_thon.lucian.feature.dild.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.high_thon.lucian.common.theme.LucianTheme

@Composable
fun DildCard(
    modifier: Modifier,
    title: String,
    description: String
) {
    LucianTheme { colors, typography ->
        Column(
            modifier = modifier
                .then(
                    Modifier.background(
                        color = Color(0x4DD9D9D9),
                        shape = RoundedCornerShape(8.dp)
                    )
                )
        ) {
            Spacer(modifier = Modifier.height(14.dp))
            Text(
                modifier = Modifier.padding(horizontal = 8.dp),
                text = title,
                color = colors.WHITE,
                style = typography.B20
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier.padding(horizontal = 8.dp),
                text = description,
                color = colors.WHITE,
                style = typography.R16
            )
            Spacer(modifier = Modifier.height(14.dp))
        }
    }
}

@Preview
@Composable
private fun DildCardPreview() {
    LucianTheme { colors, typography ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colors.BACKGROUND)
        ) {
            DildCard(
                modifier = Modifier
                    .fillMaxWidth(),
                title = "DILD란?",
                description = "꿈을 꾸고 있는 상태에서 자신이 꿈을 꾸고 있다는 사실을 자각하여 자각몽 상태로 진입하는 방법입니다."
            )
        }
    }
}