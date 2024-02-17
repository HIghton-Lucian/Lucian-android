package com.high_thon.lucian.data.local

import androidx.room.Room
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RoomListConverter {
    @TypeConverter
    fun fromRoomList(roomList: List<DiaryDao>?): String? {
        if (roomList == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<Room>>() {}.type
        return gson.toJson(roomList, type)
    }

    @TypeConverter
    fun toRoomList(roomListString: String?): List<Room>? {
        if (roomListString == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<Room>>() {}.type
        return gson.fromJson(roomListString, type)
    }
}