package com.high_thon.lucian.feature.diary

import com.high_thon.lucian.common.component.LucianTextField

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
import com.high_thon.lucian.core.Env.RC
import com.high_thon.lucian.core.LucianPage
import com.high_thon.lucian.feature.dild.component.DildButton
import com.high_thon.lucian.feature.rc.component.RcCard
import dagger.hilt.android.lifecycle.HiltViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DiaryAfterScreen(
    onClick: () -> Unit
) {
    var title by remember { mutableStateOf("") }
    var detail by remember { mutableStateOf("") }
    LucianTheme { colors, typography ->
        Column(
            modifier = Modifier
                .padding()
                .background(colors.BACKGROUND)
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(44.dp))
            LucianTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .height(60.dp),
                value = title,
                onValueChange = {
                    title = it
                },
                hint = "오늘의 꿈의 핵심 키워드로 제목을 만들어 보아요!"
            )
            Spacer(modifier = Modifier.height(16.dp))
            LucianTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .height(494.dp),
                value = detail,
                onValueChange = {
                    detail = it
                },
                hint = "오늘은 어떤 꿈을 꾸었나요?"
            )
            Spacer(modifier = Modifier.height(32.dp))
            DildButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(47.dp)
                    .padding(horizontal = 20.dp)
                    .clickable(
                        enabled = true
                    ) {
                        onClick()
                    },
                text = "작성 완료"
            )
        }
    }
}