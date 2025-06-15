package com.market.stream.websocket.source

import com.market.stream.common.RemotePriceTick
import com.market.stream.websocket.service.WebSocketService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

// TODO Real websocket source...
class AssetDataWebSocketSourceImpl @Inject constructor(
    // webSocketService: WebSocketService
) : AssetDataWebSocketSource {

    override fun subscribeToAssetStream(symbol: String) = flow {
        emit(RemotePriceTick())
    }
}