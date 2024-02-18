package com.high_thon.lucian.feature.sleep

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.high_thon.lucian.R

@Composable
fun SleepScreen(
    onClick: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.ic_sleep),
            contentDescription = "Setting Icon",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    onClick()
                }
        )
    }
}