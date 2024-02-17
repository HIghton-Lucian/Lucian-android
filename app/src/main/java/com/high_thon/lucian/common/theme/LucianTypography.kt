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
    private val suit = FontFamily(
        Font(R.font.pretendard_regular, FontWeight.Normal),
        Font(R.font.pretendard_semibold, FontWeight.SemiBold),
    )

    @Stable
    val B20 = TextStyle(
        fontFamily = suit,
        fontSize = 20.sp,
        lineHeight = 34.sp
    )

    @Stable
    val R20 = TextStyle(
        fontFamily = suit,
        fontSize = 20.sp,
        lineHeight = 34.sp
    )

    @Stable
    val B18 = TextStyle(
        fontFamily = suit,
        fontSize = 18.sp,
        lineHeight = 28.sp
    )

    @Stable
    val R18 = TextStyle(
        fontFamily = suit,
        fontSize = 18.sp,
        lineHeight = 28.sp
    )

    @Stable
    val B16 = TextStyle(
        fontFamily = suit,
        fontSize = 16.sp,
        lineHeight = 26.sp
    )

    @Stable
    val R16 = TextStyle(
        fontFamily = suit,
        fontSize = 16.sp,
        lineHeight = 26.sp
    )

    @Stable
    val B14 = TextStyle(
        fontFamily = suit,
        fontSize = 14.sp,
        lineHeight = 22.sp
    )

    @Stable
    val R14 = TextStyle(
        fontFamily = suit,
        fontSize = 14.sp,
        lineHeight = 22.sp
    )

    @Stable
    val B12 = TextStyle(
        fontFamily = suit,
        fontSize = 12.sp,
        lineHeight = 20.sp
    )

    @Stable
    val R12 = TextStyle(
        fontFamily = suit,
        fontSize = 12.sp,
        lineHeight = 20.sp
    )

    @Stable
    val B10 = TextStyle(
        fontFamily = suit,
        fontSize = 10.sp,
        lineHeight = 16.sp
    )

    @Stable
    val R10 = TextStyle(
        fontFamily = suit,
        fontSize = 10.sp,
        lineHeight = 16.sp
    )
}