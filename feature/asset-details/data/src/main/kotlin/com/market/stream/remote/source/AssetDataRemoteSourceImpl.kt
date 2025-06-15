package com.market.stream.remote.source

import com.market.stream.common.RemotePriceTick
import com.market.stream.remote.model.AssetDataApiResponse
import kotlinx.coroutines.flow.flow
import java.math.BigDecimal
import java.time.Instant
import javax.inject.Inject

// TODO complete...
class AssetDataRemoteSourceImpl @Inject constructor(
    // private val apiService: AssetApiService,
) : AssetDataRemoteSource {

    override fun getAssetData(symbol: String) = flow {
        emit(AssetDataApiResponse(history = getDummyPriceHistory()))
    }

    private fun getDummyPriceHistory(): List<RemotePriceTick> {
        val now = Instant.now()
        return List(3) { i ->
            val ts = now.minusSeconds((12 - i) * 60L).toEpochMilli()
            RemotePriceTick(
                symbol = "AAPL",
                timestamp = ts,
                price = BigDecimal("140.0").plus(BigDecimal(i).multiply(BigDecimal("0.5")))
            )
        }
    }
}