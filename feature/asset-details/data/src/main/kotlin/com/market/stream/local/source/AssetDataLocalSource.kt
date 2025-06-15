package com.market.stream.local.source

import com.market.stream.local.model.CachedAssetData
import kotlinx.coroutines.flow.Flow

// TODO Continue ..
interface AssetDataLocalSource {

    fun getAssetDetails(symbol: String): Flow<List<CachedAssetData>>

    fun saveAssetDataList(data: List<CachedAssetData>)

}
