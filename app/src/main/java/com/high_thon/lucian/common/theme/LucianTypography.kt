package com.high_thon.lucian.common.theme

import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.high_thon.lucian.R

object LucianTypography {
    private val suit = FontFamily()

    //ex
    @Stable
    val titleLarge = TextStyle(
        fontFamily = suit,
        fontSize = 46.sp,
        lineHeight = 64.sp
    )
}