package com.high_thon.lucian.data.remote.response

import com.google.gson.annotations.SerializedName


data class ImageUrlResponse(
    @field:SerializedName("url")
    val url: String
)