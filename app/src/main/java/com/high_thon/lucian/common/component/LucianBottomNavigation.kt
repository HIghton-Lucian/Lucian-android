package com.high_thon.lucian.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.high_thon.lucian.common.icon.AlarmIcon
import com.high_thon.lucian.common.icon.CalendarIcon
import com.high_thon.lucian.common.icon.HomeIcon
import com.high_thon.lucian.common.icon.SettingIcon
import com.high_thon.lucian.common.theme.LucianTheme

@Composable
fun LucianBottomNavigation(
    modifier: Modifier,
    isVisible: Boolean,
    currentRoute: String,
    onHomeClick: () -> Unit,
    onCalenderClick: () -> Unit,
    onAlarmClick: () -> Unit,
    onSettingClick: () -> Unit
) {
    if (isVisible) {
        LucianTheme { colors, typography ->
            Box(
                modifier = modifier.background(Color.Transparent),
                contentAlignment = Alignment.BottomCenter
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .padding(start = 30.dp, end = 30.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ) { onHomeClick() },
                    ) {
                        HomeIcon( isClick = currentRoute == "Home" )
                    }
                    Box(
                        modifier = Modifier
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ) { onCalenderClick() },
                    ) {
                        CalendarIcon( isClick = currentRoute == "Calender" )
                    }
                    Box(
                        modifier = Modifier
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ) { onAlarmClick() },
                    ) {
                        AlarmIcon( isClick = currentRoute == "AlarmSetting" )
                    }
                    Box(
                        modifier = Modifier
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ) { onSettingClick() },
                    ) {
                        SettingIcon( isClick = currentRoute == "Setting" )
                    }
                }
            }
        }
    }
}