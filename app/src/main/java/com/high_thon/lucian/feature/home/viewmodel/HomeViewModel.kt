package com.high_thon.lucian.feature.home.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(

): ViewModel() {

    private val _keyword = MutableStateFlow("")
    val keyword = _keyword.asStateFlow()

    fun setKeyword(
        text: String
    ) {
        _keyword.value = text
    }
}