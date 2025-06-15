package com.market.stream.common

import java.math.BigDecimal

// TODO We can reuse the same TICK remote & websocket model..
data class RemotePriceTick(
    //@Json(name = "AssetSymbol")
    val symbol: String? = null,
    //@Json(name = "AssetTickPrice")
    val price: BigDecimal? = null,
    //@Json(name = "AssetTickTimestamp")
    val timestamp: Long? = null
)