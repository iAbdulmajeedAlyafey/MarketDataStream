package com.market.stream.websocket.source

import com.market.stream.common.RemotePriceTick
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import java.math.BigDecimal
import javax.inject.Inject

/**
 * Fake webSocket source to simulate price tick changes.
 */
class AssetDataFakeWebSocketSourceImpl @Inject constructor() : AssetDataWebSocketSource {

    override fun subscribeToAssetStream(symbol: String) = flow {
        var price = BigDecimal("100.0")
        while (true) {
            val timestamp = System.currentTimeMillis()
            price = price.add(BigDecimal(((-5..5).random()).toString()))
            emit(RemotePriceTick(symbol, price, timestamp))
            delay(3_000)
        }
    }
}