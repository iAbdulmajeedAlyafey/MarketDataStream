package com.market.stream.mapper

import com.market.stream.common.RemotePriceTick
import com.market.stream.remote.model.AssetDataApiResponse
import com.market.stream.tick.PriceTick
import java.math.BigDecimal

fun AssetDataApiResponse.asPriceTickList() = history?.map(RemotePriceTick::asPriceTick).orEmpty()

fun RemotePriceTick.asPriceTick() = PriceTick(
    symbol = symbol.orEmpty(),
    timestamp = timestamp ?: 0L,
    price = price ?: BigDecimal.ZERO
)