package com.market.stream.remote.source

import com.market.stream.remote.model.AssetDataApiResponse
import kotlinx.coroutines.flow.Flow

interface AssetDataRemoteSource {

    fun getAssetData(symbol: String): Flow<AssetDataApiResponse>
}