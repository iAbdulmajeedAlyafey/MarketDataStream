package com.market.stream.usecase

import com.market.stream.repository.AssetDataRepository
import com.market.stream.tick.PriceTick
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SubscribeToAssetStreamUseCase @Inject constructor(
    private val repository: AssetDataRepository
) {

    operator fun invoke(symbol: String): Flow<PriceTick> =
        repository.subscribeToAssetStream(symbol)
}