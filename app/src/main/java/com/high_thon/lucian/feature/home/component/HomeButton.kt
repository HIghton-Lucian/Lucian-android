package com.high_thon.lucian.feature.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.high_thon.lucian.R
import com.high_thon.lucian.common.theme.LucianTheme


@Composable
fun HomeButton(
    modifier: Modifier,
    text: String,
    isSleep: Boolean
) {
    LucianTheme { colors, typography ->
        Box(
            modifier = modifier
                .then(
                    Modifier.background(
                        color = colors.SUB,
                        shape = RoundedCornerShape(12.dp)
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Box {
                Text(
                    text = text,
                    color = colors.WHITE,
                    style = typography.B20
                )
                if (isSleep) {
                    Image(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .absoluteOffset(y = (-12).dp, x = 21.dp)
                            .rotate(27f),
                        painter = painterResource(id = R.drawable.ic_zzz),
                        contentDescription = "졸리운 아이콘"
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomeButtonPreview() {
    LucianTheme { colors, typography ->
        HomeButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            text = "수면하기",
            isSleep = true
        )
    }
}