package com.high_thon.lucian.feature.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.high_thon.lucian.R
import com.high_thon.lucian.common.component.LucianTextField
import com.high_thon.lucian.common.theme.LucianTheme
import com.high_thon.lucian.core.LucianPage
import com.high_thon.lucian.feature.dild.component.DildButton
import com.high_thon.lucian.feature.home.component.HomeButton
import com.high_thon.lucian.feature.home.component.HomeHorizontalPager
import com.high_thon.lucian.feature.home.component.HomeImageHorizontalPager
import com.high_thon.lucian.feature.home.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel
) {

    val scrollState = rememberScrollState()
    val keyword = viewModel.keyword.collectAsState().value
    LucianTheme { colors, typography ->  
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colors.BACKGROUND)
                .verticalScroll(scrollState)
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
            HomeButton(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .height(56.dp)
                    .clickable(
                        enabled = true
                    ) {

                    },
                text = "수면하기",
                isSleep = true
            )
            
            
            Spacer(modifier = Modifier.height(31.dp))
            Text(
                modifier = Modifier.padding(start = 20.dp),
                text = "AI가 알려주는 꿈 이야기",
                color = colors.WHITE,
                style = typography.B20
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                modifier = Modifier.padding(start = 25.dp),
                text = "키워드들 입력하면 AI가 꿈속 세상을 보여줍니다",
                color = colors.GRAY4,
                style = typography.B14
            )
            Spacer(modifier = Modifier.height(27.dp))
            LucianTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .height(47.dp),
                value = keyword,
                onValueChange = {
                    viewModel.setKeyword(it)
                },
                hint = "키워드 입력"
            )
            Spacer(modifier = Modifier.height(16.dp))
            DildButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(47.dp)
                    .padding(horizontal = 20.dp)
                    .clickable(
                        enabled = true
                    ) {
                        if (keyword.isNotBlank() && keyword.length > 4) {
                            navController.navigate(LucianPage.HomeResult.value.replace("{keyword}", keyword))
                        }
                    },
                text = "결과 보기"
            )


            Spacer(modifier = Modifier.height(31.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp, end = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier,
                    text = "이런 꿈은 어떠세요?",
                    color = colors.WHITE,
                    style = typography.B20
                )
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .clickable(
                            enabled = true
                        ) {

                        },
                    painter = painterResource(id = R.drawable.ic_edit),
                    contentDescription = "작성하기"
                )
            }

            Spacer(modifier = Modifier.height(14.dp))
            HomeImageHorizontalPager(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp),
                items = listOf("test", "test", "test"),
                onItemClick = {}
            )

            Spacer(modifier = Modifier.height(31.dp))
            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = "RC를 정해보세요!",
                color = colors.WHITE,
                style = typography.B20
            )
            Spacer(modifier = Modifier.height(24.dp))
            HomeHorizontalPager(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(78.dp),
                items = listOf("test", "test", "test")
            )
            Spacer(modifier = Modifier.height(39.dp))

        }
    }
}