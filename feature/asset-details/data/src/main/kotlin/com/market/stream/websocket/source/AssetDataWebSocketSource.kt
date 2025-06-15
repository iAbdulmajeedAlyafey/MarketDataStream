package com.market.stream.websocket.source

import com.market.stream.common.RemotePriceTick
import kotlinx.coroutines.flow.Flow

interface AssetDataWebSocketSource {

    fun subscribeToAssetStream(symbol: String): Flow<RemotePriceTick>
}