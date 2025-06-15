package com.market.stream.remote.api

import com.market.stream.remote.model.AssetDataApiResponse

// TODO complete API service using Retrofit and Moshi serializer..
interface AssetApiService {

    // @GET("cards/{symbol}")
    suspend fun getAssetDetails(symbol: String): AssetDataApiResponse
}