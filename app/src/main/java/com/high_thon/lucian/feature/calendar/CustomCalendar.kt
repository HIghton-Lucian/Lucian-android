package com.high_thon.lucian.feature.calendar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
    yearMonth: YearMonth = YearMonth.now(),
    textColor: Color = Color.White,
    dateContent: @Composable (Modifier, Int) -> Unit,
) {
    val daysInMonth = yearMonth.lengthOfMonth()
    val firstOfMonth = yearMonth.atDay(1)
    val dayOfWeekOfFirst = firstOfMonth.dayOfWeek.value

    val formatter = DateTimeFormatter.ofPattern("MMMM yyyy", Locale.US)

    Column {
        Text(
            text = yearMonth.format(formatter),
            style = LucianTypography.B20,
            color = textColor,
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Header
        Row(modifier = Modifier.fillMaxWidth()) {
            DayOfWeek.values().forEach { dayOfWeek ->
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentWidth(CenterHorizontally),
                    text = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault()),
                    color = textColor,
                    style = LucianTypography.R10,
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
        }
    }
}

@Preview
@Composable
private fun PreviewCalendarView() {
    CustomCalendar { modifier, day ->
        Text(
            modifier = modifier
                .padding(vertical = 4.dp)
                .wrapContentWidth(CenterHorizontally),
            text = day.toString(),
            style = LucianTypography.R16,
        )
    }
}