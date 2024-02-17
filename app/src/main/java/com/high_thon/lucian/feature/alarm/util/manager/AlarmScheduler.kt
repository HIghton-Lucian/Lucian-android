package com.high_thon.lucian.feature.alarm.util.manager

import com.high_thon.lucian.data.rocal.model.AlarmModel

interface AlarmScheduler {
    fun setSchedule(alarmItem: AlarmModel)
    fun cancel()
}