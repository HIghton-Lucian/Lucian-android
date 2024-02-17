package com.high_thon.lucian.feature.home.result.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.high_thon.lucian.data.remote.repository.ChatGptRepository
import com.high_thon.lucian.feature.home.result.contract.HomeResultSideEffect
import com.high_thon.lucian.feature.home.result.contract.HomeResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeResultViewModel @Inject constructor(
    private val chatGptRepository: ChatGptRepository
): ViewModel() {

    private val _state = MutableStateFlow(HomeResultState())
    val state = _state.asStateFlow()

    private val _sideEffect = Channel<HomeResultSideEffect>()
    val sideEffect = _sideEffect.receiveAsFlow()

    fun createImage(
        keyword: String
    ) = viewModelScope.launch(Dispatchers.IO) {
        kotlin.runCatching {
            chatGptRepository.postImageGenerate(keyword = keyword)
        }.onSuccess {
            Log.d("TAG", "createImage: ${it.image}") 
            _state.value = _state.value.copy(
                loading = false,
                image = it.image
            )
        }.onFailure {
            it.printStackTrace()
            _sideEffect.send(HomeResultSideEffect.Error(it))
        }
    }
}