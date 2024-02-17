package com.high_thon.lucian.feature.home.result.contract

data class HomeResultState(
    val loading: Boolean = true,
    val image: String? = null
)


sealed class HomeResultSideEffect {
    data class Error(val throwable: Throwable): HomeResultSideEffect()
}