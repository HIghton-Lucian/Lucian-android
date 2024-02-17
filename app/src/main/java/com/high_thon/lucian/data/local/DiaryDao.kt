package com.high_thon.lucian.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DiaryDao {
    @Query("SELECT * FROM diaryModel")
    fun getDiaryList(): List<DiaryModel>

    @Insert
    fun insertDiary(model: DiaryModel)
}