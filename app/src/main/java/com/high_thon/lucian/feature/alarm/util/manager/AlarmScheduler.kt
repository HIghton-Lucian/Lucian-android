package com.high_thon.lucian.feature.alarm.util.manager

import com.high_thon.lucian.data.local.model.AlarmModel

interface AlarmScheduler {
    fun setSchedule(alarmItem: AlarmModel)
    fun cancel()
}