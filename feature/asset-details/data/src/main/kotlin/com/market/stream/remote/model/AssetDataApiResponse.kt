package com.market.stream.remote.model

import com.market.stream.common.RemotePriceTick

// TODO continue...
data class AssetDataApiResponse(
    //@Json(name = "AssetHistory")
    val history: List<RemotePriceTick>? = null
)

