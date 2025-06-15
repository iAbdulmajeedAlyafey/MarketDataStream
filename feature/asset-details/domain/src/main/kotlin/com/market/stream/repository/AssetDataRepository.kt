package com.market.stream.repository

import com.market.stream.tick.PriceTick
import kotlinx.coroutines.flow.Flow

interface AssetDataRepository {

    fun getAssetData(symbol: String): Flow<List<PriceTick>>

    fun subscribeToAssetStream(symbol: String): Flow<PriceTick>

}