package com.high_thon.lucian.feature.alarm.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.high_thon.lucian.data.rocal.model.AlarmModel
import com.high_thon.lucian.feature.alarm.util.manager.AlarmScheduler
import com.high_thon.lucian.feature.alarm.util.manager.AlarmSchedulerImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AlarmViewModel @Inject constructor(): ViewModel() {
    fun setAlarmScheduler(
        context: Context,
        isAfternoon: Boolean,
        alarmHour: Int,
        alarmMinute: Int
    ) {
        val alarmScheduler: AlarmScheduler = AlarmSchedulerImpl(context)
        val alarmModel: AlarmModel = AlarmModel(
            isAfternoon = isAfternoon,
            alarmHour = alarmHour,
            alarmMinute = alarmMinute
        )

        alarmModel.let(alarmScheduler::setSchedule)
    }
}