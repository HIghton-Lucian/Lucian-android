package com.high_thon.lucian.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import com.high_thon.lucian.common.theme.LucianTheme

enum class Progress(val value: Int) {
    DIARY(1),
    RC(2),
    ALARM(3)
}


//@Preview
@Composable
fun ProgressBar(
    modifier: Modifier,
    progress: Progress
) {
    val density = LocalDensity.current
    var progressHeightPx by remember { mutableStateOf(0f) }
    var progressWidthPx by remember { mutableStateOf(0f) }
    LucianTheme { colors, typography ->
        Box(modifier = modifier) {
            LinearProgressIndicator(
                progress = when(progress.value) {
                    1 -> 0.15f
                    2 -> 0.75f
                    3 -> 1f
                    else -> 1f
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 35.dp)
                    .align(Alignment.CenterStart)
                    .offset(y = 10.dp)
                    .onGloballyPositioned { coordinates ->
                        progressWidthPx = coordinates.size.width.toFloat()
                        progressHeightPx = coordinates.size.height.toFloat()
                    },
                color = colors.LIGHTBLUE1,
                backgroundColor = colors.GRAY5
            )

            PlaceDotWithText("수면 전 꿈 일기", progress.value >= 1, 0f, progressWidthPx, progressHeightPx, density)
            PlaceDotWithText("RC", progress.value >= 2, 0.4f, progressWidthPx, progressHeightPx, density)
            PlaceDotWithText("알람 설정", progress.value >= 3, 1f, progressWidthPx, progressHeightPx, density, true)
        }
    }
}

@Composable
private fun PlaceDotWithText(
    text: String,
    pick: Boolean,
    position: Float,
    totalWidth: Float,
    height: Float,
    density: Density,
    isLast: Boolean = false
) {
    LucianTheme { colors, typography ->
        val xPos = with(density) { (totalWidth * position).toDp() }
        val yPos = with(density) { (height / 2).toDp() }
        val color = if (pick) colors.LIGHTBLUE1 else colors.GRAY5
        Column(
            modifier = Modifier.offset(x = xPos + if(isLast) 15.dp else 0.dp, y = yPos),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = text,
                color = colors.WHITE,
                style = typography.B10
            )
            Spacer(modifier = Modifier.height(5.dp))
            Box(
                modifier = Modifier
                    .size(15.dp)
                    .background(color, CircleShape)
                    .onGloballyPositioned { coordinates ->
                        coordinates.positionInParent().y.dp
                    }
            )
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}



@Preview
@Composable
private fun ProgressPreview() {
    LucianTheme { colors, typography ->
        ProgressBar(
            modifier = Modifier
                .fillMaxWidth()
                .height(53.dp),
            progress = Progress.DIARY
        )
    }
}