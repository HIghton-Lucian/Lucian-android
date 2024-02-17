package com.high_thon.lucian.feature.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.high_thon.lucian.common.component.LucianTextField
import com.high_thon.lucian.common.theme.LucianTypography
import com.high_thon.lucian.common.theme.color.LightColor
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CalendarScreen(
    selectedDay: Int,
    listOfCompletedDiaryDay: List<Int>
) {
    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()

    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    ModalBottomSheetLayout(
        modifier = Modifier
            .fillMaxSize()
            .imePadding()
            .background(
                color = LightColor.BACKGROUND,
            )
            .padding(top = 32.dp),
        sheetState = sheetState,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        sheetContent = {
            Column(
                Modifier
                    .clip(
                        RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
                    )
                    .background(LightColor.BACKGROUND)
                    .padding(
                        vertical = 24.dp,
                        horizontal = 24.dp,
                    ),
            ) {
                LucianTextField(
                    value = title,
                    onValueChange = { title = it },
                    hint = "제목을 입력 해주세요."
                )
                Spacer(modifier = Modifier.height(12.dp))
                LucianTextField(
                    value = content,
                    onValueChange = { content = it },
                    hint = "꿈의 내용을 입력 해주세요.",
                )
                Spacer(modifier = Modifier.height(24.dp))
                Divider(
                    color = LightColor.SUBPrimary
                )
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFF41495B),
                        contentColor = Color.White,
                        disabledBackgroundColor = Color(0xFF909297),
                        disabledContentColor = Color.White,
                    )
                ) {
                    Text(
                        text = "수정",
                        style = LucianTypography.B18,
                    )
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
        ) {
            CustomCalendar { modifier, day ->
                Box(
                    modifier = modifier
                        .clickable {
                            coroutineScope.launch { sheetState.show() }
                        }
                        .padding(vertical = 16.dp),
                ) {
                    when {
                        day == selectedDay -> Text(
                            modifier = Modifier
                                .drawBehind {
                                    drawCircle(
                                        color = LightColor.BLUE,
                                        radius = 12.dp.toPx(),
                                    )
                                },
                            text = day.toString(),
                            color = Color.White,
                        )

                        listOfCompletedDiaryDay.contains(day) -> Text(
                            modifier = Modifier
                                .drawBehind {
                                    val underlineThickness = 2.dp.toPx()
                                    val underlineY =
                                        size.height - underlineThickness / 2 // 밑줄의 y 좌표
                                    drawLine(
                                        color = LightColor.BLUE,
                                        start = Offset(0f, underlineY),
                                        end = Offset(size.width, underlineY),
                                        strokeWidth = underlineThickness
                                    )
                                },
                            text = day.toString(),
                            color = Color.White,
                        )

                        else -> Text(
                            modifier = Modifier,
                            text = day.toString(),
                            color = Color.White,
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewCalendarScreen() {
    CalendarScreen(
        selectedDay = 22,
        listOfCompletedDiaryDay = listOf(1, 3, 28),
    )
}