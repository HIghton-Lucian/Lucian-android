package com.high_thon.lucian.data.remote.mapper

import com.high_thon.lucian.data.remote.model.ImageModel
import com.high_thon.lucian.data.remote.request.ImageGenerateRequest
import com.high_thon.lucian.data.remote.response.ImageGenerateResponse

internal fun ImageGenerateResponse.toModel(): ImageModel {
    return ImageModel(this.data[0].url)
}