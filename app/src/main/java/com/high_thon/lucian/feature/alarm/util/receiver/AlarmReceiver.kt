package com.high_thon.lucian.feature.alarm.util.receiver

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent != null){
            Log.d("alarm", System.currentTimeMillis().toString() + "suc")
        }
    }
}