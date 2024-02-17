package com.high_thon.lucian.data.remote.response

import com.google.gson.annotations.SerializedName


data class ImageGenerateResponse (
    @field:SerializedName("created")
    val created: Int,
    @field:SerializedName("data")
    val data: List<ImageUrlResponse>,
)