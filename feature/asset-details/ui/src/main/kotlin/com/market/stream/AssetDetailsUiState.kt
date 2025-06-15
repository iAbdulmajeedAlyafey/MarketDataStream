package com.market.stream

import com.market.stream.tick.PriceTick

data class AssetDetailsUiState(
    val symbol: String? = null,
    val loading: Boolean = true,
    val history: List<PriceTick> = emptyList()
)