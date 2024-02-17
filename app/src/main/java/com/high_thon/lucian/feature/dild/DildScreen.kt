package com.high_thon.lucian.feature.dild

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.high_thon.lucian.common.theme.LucianTheme
import com.high_thon.lucian.feature.dild.component.DildButton
import com.high_thon.lucian.feature.dild.component.DildCard
import com.high_thon.lucian.feature.home.component.HomeButton

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DildScreen(
    navController: NavController
) {

    val pagerState = rememberPagerState()
    val items = listOf(
        listOf(
            Pair("루시드 드림을 왜 하나요?", "루시드 드림을 하는 이유 중 하나는 꿈에서 무엇이든지 가능하기 때문입니다.\n날고 싶다면 날 수 있으며 상상하는 일 모든 것이 가능합니다."),
            Pair("DILD 사전적 의미", "꿈을 꾸고 있는 상태에서 자신이 꿈을 꾸고 있다는 사실을 자각하여 자각몽 상태로 진입하는 방법입니다.")
        ),
        listOf(
            Pair("왜 DILD를 통해 루시드 드림에 도전하나요?", "자각몽을 시도할 수 있는 방법 중 앱을 통해 도와줄 수 있는 유일한 방법이며 가장 대중적인 방법이기도 합니다."),
            Pair("어떻게 도전하나요?", "Reality Check 통칭 RC(손가락 꺾기, 허리 비틀기 등)를 통하여 꿈임을 자각합니다.\n꾼 꿈을 기록하여 자주 보이는 물체 통칭 꿈 표식을 자각함으로써 꿈임을 자각합니다."),
            Pair("얼마나 오래 걸리나요?", "사람마다 다르며 1주일에서 1년으로 천차만별입니다.")
        )
    )
    val itemCount = 3
    LucianTheme { colors, typography ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colors.BACKGROUND)
        ) {
            Box(modifier = Modifier
                .fillMaxSize()
                .navigationBarsPadding()
            ) {
                Row(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 25.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    for (i in 0 until  itemCount) {
                        var sizeState by remember { mutableStateOf(if (i == pagerState.currentPage) 24.dp else 12.dp) }
                        val size by animateDpAsState(targetValue = sizeState,
                            label = ""
                        )
                        LaunchedEffect(key1 = pagerState.currentPage) {
                            sizeState = if (i == pagerState.currentPage) 24.dp else 12.dp
                        }
                        Box(
                            modifier = Modifier
                                .size(size)
                                .background(colors.LIGHTBLUE1, CircleShape)
                        )
                        if (i != itemCount-1) {
                            Spacer(modifier = Modifier.width(11.dp))
                        }
                    }
                }
                HorizontalPager(
                    modifier = Modifier.fillMaxSize(),
                    state = pagerState,
                    pageCount = itemCount,
                    verticalAlignment = Alignment.Top
                ) { page ->
                    if (page == 2) {
                        Box(modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.TopCenter)
                        ) {
                            DildButton(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(
                                        start = 23.dp,
                                        end = 23.dp,
                                        bottom = 22.dp
                                    )
                                    .align(Alignment.BottomCenter)
                                    .clickable(
                                        enabled = true
                                    ) {

                                    },
                                text = "튜토리얼 종료하기"
                            )
                        }
                    } else {
                        val scrollState = rememberScrollState()
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .verticalScroll(scrollState)
                        ) {
                            Spacer(modifier = Modifier.height(113.dp))
                            items[page].forEachIndexed { i, item ->
                                DildCard(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 16.dp),
                                    title = item.first,
                                    description = item.second
                                )
                                if (i != itemCount-1) {
                                    Spacer(modifier = Modifier.height(28.dp))
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}