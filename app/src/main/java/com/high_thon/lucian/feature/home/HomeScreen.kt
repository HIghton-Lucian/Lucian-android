package com.high_thon.lucian.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.high_thon.lucian.common.theme.LucianTheme
import com.high_thon.lucian.feature.home.component.HomeButton
import com.high_thon.lucian.feature.home.component.HomeHorizontalPager
import com.high_thon.lucian.feature.home.component.HomeImageHorizontalPager

@Composable
fun HomeScreen(
    navController: NavController
) {
    val scrollState = rememberScrollState()

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
                modifier = Modifier.padding(start = 16.dp),
                text = "이런 꿈은 어떠세요?",
                color = colors.WHITE,
                style = typography.B20
            )

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