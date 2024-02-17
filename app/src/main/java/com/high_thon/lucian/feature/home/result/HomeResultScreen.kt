package com.high_thon.lucian.feature.home.result

import android.widget.Toast
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImagePainter.State.Empty.painter
import coil.compose.rememberAsyncImagePainter
import com.high_thon.lucian.R
import com.high_thon.lucian.common.theme.LucianTheme
import com.high_thon.lucian.core.CollectAsSideEffect
import com.high_thon.lucian.feature.dild.component.DildButton
import com.high_thon.lucian.feature.home.result.contract.HomeResultSideEffect
import com.high_thon.lucian.feature.home.result.viewmodel.HomeResultViewModel


@Composable
fun HomeResultScreen(
    navController: NavController,
    viewModel: HomeResultViewModel,
    keyword: String,
) {
    val context = LocalContext.current
    val state = viewModel.state.collectAsState().value

    LaunchedEffect(key1 = true) {
        viewModel.createImage(keyword)
    }

    viewModel.sideEffect.CollectAsSideEffect {
        when(it) {
            is HomeResultSideEffect.Error -> {
                Toast.makeText(context, "에러가 발생했습니다", Toast.LENGTH_SHORT).show()
            }
        }
    }

    LucianTheme { colors, typography ->
        if (state.loading) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colors.BACKGROUND),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painter = painterResource(id = R.drawable.ic_edit), contentDescription = "")
            }
        } else {
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
                    painter = rememberAsyncImagePainter(model = state.image),
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
}