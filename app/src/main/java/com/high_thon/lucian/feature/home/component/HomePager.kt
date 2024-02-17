package com.high_thon.lucian.feature.home.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.high_thon.lucian.R
import com.high_thon.lucian.common.theme.LucianTheme


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeImageHorizontalPager(
    modifier: Modifier,
    items: List<String>,
    onItemClick: (String) -> Unit
) {
    val pagerState = rememberPagerState()
    LucianTheme { colors, typography ->
        Column {
            Box(
                modifier = modifier
            ) {
                HorizontalPager(
                    modifier = Modifier
                        .height(232.dp),
                    state = pagerState,
                    pageSpacing = 24.dp,
                    contentPadding = PaddingValues(horizontal = 90.dp),
                    pageCount = Int.MAX_VALUE
                ) { page ->
                    // 앞 페이지 상태 관리
                    val nowPage = page % items.size
                    val show = nowPage == pagerState.currentPage % items.size
                    var paddingValueState by remember { mutableStateOf(34.dp) }
                    val paddingValue by animateDpAsState(targetValue = paddingValueState,
                        label = ""
                    )

                    // 뒷 페이지 상태관리
                    val backVisible = remember { mutableStateOf(true) }
                    val rotationYs by animateFloatAsState(if (backVisible.value) 0f else 180f,
                        label = ""
                    )
                    val imagePainter = rememberAsyncImagePainter(model = "https://img.koreatimes.co.kr/upload/newsV2/images/202304/c3b7c2f4d1fc4274977b9a8101fd63c3.jpg")

                    LaunchedEffect(key1 = show) {
                        paddingValueState = if (show) 0.dp else 34.dp
                        if (!show) {
                            backVisible.value = true
                        }
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Surface(
                            modifier = Modifier
                                .fillMaxSize()
                                .clickable {
                                    if (show) {
                                        backVisible.value = !backVisible.value
                                    }
                                    onItemClick(items[nowPage])
                                }
                                .clipToBounds()
                                .padding(vertical = paddingValue)
                                .graphicsLayer {
                                    rotationX = rotationYs
                                },
                            color = Color(0xFF2C3853),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            this@Column.AnimatedVisibility(
                                visible = show,
                                enter = fadeIn(
                                    animationSpec = tween(1000)
                                ),
                                exit = fadeOut(
                                    animationSpec = tween(1000)
                                )
                            ) {
                                if (backVisible.value) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(horizontal = 24.dp, vertical = 16.dp)
                                    ) {
                                        Spacer(modifier = Modifier.height(16.dp))
                                        Text(
                                            text = items[nowPage],
                                            color = colors.WHITE,
                                            style = typography.B12,
                                            modifier = Modifier
                                                .fillMaxSize()
                                        )

                                        Spacer(modifier = Modifier.height(22.dp))
                                        Text(
                                            text = items[nowPage],
                                            color = colors.WHITE,
                                            style = typography.R12,
                                            modifier = Modifier
                                                .fillMaxSize()
                                        )

                                        Spacer(modifier = Modifier.weight(1f))
                                        Text(
                                            text = items[nowPage],
                                            color = colors.GRAY3,
                                            style = typography.R12,
                                            modifier = Modifier
                                                .fillMaxSize()
                                        )
                                    }
                                } else {
                                    Image(
                                        modifier = Modifier
                                            .align(Alignment.Center)
                                            .rotate(180f)
                                            .padding(vertical = 24.dp, horizontal = 16.dp),
                                        painter = imagePainter,
                                        contentDescription = "Front"
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PagerPreview() {
    LucianTheme { colors, typography ->  
        HomeImageHorizontalPager(
            modifier = Modifier
                .height(280.dp)
                .fillMaxWidth(),
            items = listOf("test ", "test ", "test ", "test "),
            onItemClick = {}
        )
    }
}