package com.market.stream.usecase

import com.market.stream.repository.AssetDataRepository
import com.market.stream.tick.PriceTick
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Use cases are optional, and you should use them only when you have a business logic that is common
 * and reused by multiple view models, otherwise consider injecting Repository directly.
 */
class GetAssetDataUseCase @Inject constructor(
    private val repository: AssetDataRepository
) {

    operator fun invoke(symbol: String): Flow<List<PriceTick>> =
        repository.getAssetData(symbol)
}