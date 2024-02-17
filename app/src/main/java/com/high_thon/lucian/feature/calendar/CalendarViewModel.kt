package com.high_thon.lucian.feature.calendar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.high_thon.lucian.data.local.DiaryDao
import com.high_thon.lucian.data.local.DiaryModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject


@HiltViewModel
class CalendarViewModel @Inject constructor(
    private val diaryDao: DiaryDao
) : ViewModel() {

    private val _diary = MutableStateFlow<List<DiaryModel>>(value = listOf())
    val diary: StateFlow<List<DiaryModel>> = _diary

    init {
        getDiary()
    }

    private fun getDiary() = viewModelScope.launch(Dispatchers.IO) {
        val diaryList = diaryDao.getDiaryList()
        _diary.value = diaryList
    }

    fun saveDiary(title: String, content: String, date: LocalDate) = viewModelScope.launch(Dispatchers.IO) {
        val model = DiaryModel(title = title, content = content, date = date)
        _diary.value = _diary.value.plus(model)
        diaryDao.insertDiary(model)
    }
}