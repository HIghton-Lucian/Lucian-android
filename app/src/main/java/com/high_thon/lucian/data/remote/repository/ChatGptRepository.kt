package com.high_thon.lucian.data.remote.repository

import com.high_thon.lucian.BuildConfig
import com.high_thon.lucian.data.remote.mapper.toModel
import com.high_thon.lucian.data.remote.model.ImageModel
import com.high_thon.lucian.data.remote.request.ImageGenerateRequest
import com.high_thon.lucian.data.remote.response.ImageGenerateResponse
import com.high_thon.lucian.data.remote.service.ChatGptService
import javax.inject.Inject

class ChatGptRepository @Inject constructor(
    private val chatGptService: ChatGptService
) {
    suspend fun postImageGenerate(
        keyword: String
    ): ImageModel = chatGptService.postImageGenerate(
            token = "Bearer ${BuildConfig.CHATGPT}",
            ImageGenerateRequest(
                prompt = keyword
            )
        ).toModel()
}