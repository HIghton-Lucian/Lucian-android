package com.high_thon.lucian.feature.home.result

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImagePainter.State.Empty.painter
import com.high_thon.lucian.R
import com.high_thon.lucian.common.theme.LucianTheme
import com.high_thon.lucian.feature.dild.component.DildButton
import com.high_thon.lucian.feature.home.result.viewmodel.HomeResultViewModel


@Composable
fun HomeResultScreen(
    navController: NavController,
    viewModel: HomeResultViewModel,
    keyword: String,
) {
    LucianTheme { colors, typography ->  
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colors.BACKGROUND),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "입력하신 키워드로 만든 꿈속 세계입니다!",
                color = colors.WHITE,
                style = typography.B18
            )
            Spacer(modifier = Modifier.height(12.dp))
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(15.dp)),
                painter = painterResource(id = R.drawable.ic_edit),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(12.dp))
            DildButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 23.dp)
                    .clickable(
                        enabled = true
                    ) {
                        navController.popBackStack()
                    },
                text = "닫기"
            )
        }
    }
}