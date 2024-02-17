package com.high_thon.lucian.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.high_thon.lucian.data.local.DiaryDao
import com.high_thon.lucian.data.local.DiaryModel
import com.high_thon.lucian.data.local.LocalDateConverter
import com.high_thon.lucian.data.local.RoomListConverter

@Database(entities = [DiaryModel::class], version = 1)
@TypeConverters(RoomListConverter::class, LocalDateConverter::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun diaryDao(): DiaryDao

    companion object {
        fun create(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDataBase::class.java,
                "AppDataBase"
            ).build()
    }
}