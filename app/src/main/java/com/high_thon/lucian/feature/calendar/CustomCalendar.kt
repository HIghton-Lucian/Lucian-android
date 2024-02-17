package com.high_thon.lucian.feature.calendar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.high_thon.lucian.common.theme.LucianTypography
import java.time.DayOfWeek
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun CustomCalendar(
    initialYearMonth: YearMonth = YearMonth.now(),
    textColor: Color = Color.White,
    onMonthChanged: (YearMonth) -> Unit,
    dateContent: @Composable (Modifier, Int) -> Unit,
) {
    var yearMonth by remember { mutableStateOf(initialYearMonth) }
    val daysInMonth = yearMonth.lengthOfMonth()
    val firstOfMonth = yearMonth.atDay(1)
    val dayOfWeekOfFirst = firstOfMonth.dayOfWeek.value
    val formatter = DateTimeFormatter.ofPattern("MMMM yyyy", Locale.US)

    Column(horizontalAlignment = CenterHorizontally) {
        Text(
            text = yearMonth.format(formatter),
            color = textColor,
        )

        Spacer(modifier = Modifier.height(24.dp))

        // 월 변경 버튼
        Row {
            Button(onClick = {
                yearMonth = yearMonth.minusMonths(1)
                onMonthChanged(yearMonth)
            }) {
                Text("Previous")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = {
                yearMonth = yearMonth.plusMonths(1)
                onMonthChanged(yearMonth)
            }) {
                Text("Next")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Header
        Row(modifier = Modifier.fillMaxWidth()) {
            DayOfWeek.values().forEach { dayOfWeek ->
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentWidth(CenterHorizontally),
                    text = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault()),
                    color = textColor,
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        var dayOfMonth = 1 - dayOfWeekOfFirst + 1
        while (dayOfMonth <= daysInMonth) {
            Row(modifier = Modifier.fillMaxWidth()) {
                for (dayOfWeek in 1..7) {
                    if (dayOfMonth in 1..daysInMonth) {
                        val date = yearMonth.atDay(dayOfMonth)
                        dateContent(
                            Modifier
                                .weight(1f)
                                .wrapContentWidth(CenterHorizontally),
                            dayOfMonth
                        )
                    } else {
                        // 빈 칸
                        Text(text = "", modifier = Modifier.weight(1f))
                    }
                    dayOfMonth++
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Preview
@Composable
private fun PreviewCalendarView() {
    CustomCalendar(
        onMonthChanged = { _ -> }
    ) { modifier, day ->
        Text(
            modifier = modifier
                .padding(vertical = 4.dp)
                .wrapContentWidth(CenterHorizontally),
            text = day.toString(),
            style = LucianTypography.R16,
        )
    }
}