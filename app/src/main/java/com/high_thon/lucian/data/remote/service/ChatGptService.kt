package com.high_thon.lucian.data.remote.service

import com.high_thon.lucian.data.remote.request.ImageGenerateRequest
import com.high_thon.lucian.data.remote.response.ImageGenerateResponse
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ChatGptService {

    @POST("/v1/images/generations")
    suspend fun postImageGenerate(
        @Header("Authorization") token: String,
        @Body body: ImageGenerateRequest
    ): ImageGenerateResponse
}