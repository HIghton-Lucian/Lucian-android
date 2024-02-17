package com.high_thon.lucian.feature.alarm.util.manager

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import com.high_thon.lucian.data.local.model.AlarmModel
import com.high_thon.lucian.feature.alarm.util.receiver.AlarmReceiver
import java.util.Calendar

class AlarmSchedulerImpl(
    private val context: Context
) : AlarmScheduler {
    private var alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    override fun setSchedule(alarmItem: AlarmModel) {
        var intent = Intent(context, AlarmReceiver::class.java)
        var pendingIntent = PendingIntent.getBroadcast(context, 0, intent,
            PendingIntent.FLAG_CANCEL_CURRENT or PendingIntent.FLAG_IMMUTABLE)

        val calendar = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, alarmItem.alarmHour)
            set(Calendar.MINUTE, alarmItem.alarmMinute)
            set(Calendar.SECOND,0)
        }

        try {
            alarmManager.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                calendar.timeInMillis,
                pendingIntent
            )
            Log.d("alarm","alarm set")
        } catch (e: SecurityException) {
            Log.e("alarm", "fail")
        }
    }

    override fun cancel() {
        var intent = Intent(context, AlarmReceiver::class.java)
        var pendingIntent = PendingIntent.getBroadcast(context, 1, intent,
            PendingIntent.FLAG_IMMUTABLE)
        alarmManager.cancel(pendingIntent)
    }
}