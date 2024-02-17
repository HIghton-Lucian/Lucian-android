package com.high_thon.lucian.feature.rc

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import com.high_thon.lucian.common.component.Progress
import com.high_thon.lucian.common.component.ProgressBar
import com.high_thon.lucian.common.theme.LucianTheme
import com.high_thon.lucian.feature.dild.component.DildButton
import com.high_thon.lucian.feature.rc.component.RcCard
import dagger.hilt.android.lifecycle.HiltViewModel

@Preview
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RcScreen(

) {
    var chooseList: List<String> by remember { mutableStateOf(emptyList()) }
    var rcList by remember { mutableStateOf(listOf("손가락 꺾기", "손목 움직이기", "관절 스트레칭")) }

    var isEdit by remember { mutableStateOf(true) }

    val scrollState = rememberScrollState()
    LucianTheme { colors, typography ->  
        Scaffold(
            topBar = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colors.BACKGROUND)
                ) {
                    Spacer(modifier = Modifier.height(16.dp))
                    ProgressBar(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(53.dp),
                        progress = Progress.RC
                    )
                    
                }
            },
            bottomBar = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colors.BACKGROUND),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (!isEdit) {
                        Text(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .clickable(
                                    enabled = true
                                ) {
                                    isEdit = false
                                },
                            text = "RC를 수정하고 싶으신가요?",
                            color = colors.LIGHTBLUE1,
                            style = typography.B20
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                    DildButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .padding(horizontal = 23.dp)
                            .clickable(
                                enabled = chooseList.isNotEmpty()
                            ) {

                            },
                        text = "다음"
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                }
            }
        ) {
            Column(
                modifier = Modifier
                    .padding(it)
                    .background(colors.BACKGROUND)
                    .fillMaxSize()
            ) {
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    modifier = Modifier.padding(start = 23.dp),
                    text = "RC를 확인하세요!",
                    color = colors.WHITE,
                    style = typography.B20
                )
                Spacer(modifier = Modifier.height(76.dp))

                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = if (chooseList.isNotEmpty()) "사용자 님이 선택한 RC는.." else "사용자 님이 선택한 RC가 없습니다",
                    color = colors.WHITE,
                    style = typography.B20
                )
                Spacer(modifier = Modifier.height(18.dp))

                Column(
                    modifier = Modifier
                        .height(176.dp)
                        .fillMaxWidth()
                        .verticalScroll(scrollState)
                ) {
                    Spacer(modifier = Modifier.height(10.dp))
                    chooseList.forEachIndexed { index, item ->
                        RcCard(
                            modifier = Modifier
                                .widthIn(min = 232.dp)
                                .fillMaxWidth()
                                .height(78.dp)
                                .padding(horizontal = 64.dp),
                            text = item,
                            enabled = isEdit,
                            onDeleteClick = {
                                val mu = chooseList.toMutableList()
                                mu.removeAt(chooseList.indexOf(it))
                                chooseList = mu

                                val rcMu = rcList.toMutableList()
                                rcMu.add(it)
                                rcList = rcMu
                            }
                        )
                        if (chooseList.lastIndex != index) {
                            Spacer(modifier = Modifier.height(12.dp))
                        }
                    }
                }
                Spacer(modifier = Modifier.height(29.dp))
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = "입니다!",
                    color = if (chooseList.isNotEmpty()) colors.WHITE else colors.TRANSPARENT,
                    style = typography.B20
                )

                if (isEdit) {
                    val state = rememberPagerState()

                    Spacer(modifier = Modifier.height(40.dp))
                    Text(
                        modifier = Modifier.padding(start = 17.dp),
                        text = "RC를 정해보세요!",
                        color = colors.WHITE,
                        style = typography.B20
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    HorizontalPager(
                        state = state,
                        pageCount = rcList.size,
                        pageSpacing = 24.dp,
                        contentPadding = PaddingValues(horizontal = 90.dp),
                    ) {
                        RcCard(
                            modifier = Modifier
                                .width(232.dp)
                                .fillMaxWidth()
                                .height(78.dp)
                                .clickable {
                                    val mu = chooseList.toMutableList()
                                    mu.add(rcList[it])
                                    chooseList = mu

                                    val rcMu = rcList.toMutableList()
                                    rcMu.removeAt(rcList.indexOf(rcList[it]))
                                    rcList = rcMu
                                },
                            text = rcList[it],
                            enabled = false,
                            onDeleteClick = {}
                        )
                    }
                }
            }
        }
    }
}