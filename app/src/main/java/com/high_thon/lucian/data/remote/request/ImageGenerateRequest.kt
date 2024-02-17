package com.high_thon.lucian.data.remote.request

import com.google.gson.annotations.SerializedName

data class ImageGenerateRequest(
    @field:SerializedName("prompt")
    val prompt: String,
    @field:SerializedName("size")
    val size: String = "512x512"
)