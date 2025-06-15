package com.market.stream.repository

import com.market.stream.common.RemotePriceTick
import com.market.stream.local.source.AssetDataLocalSource
import com.market.stream.mapper.asPriceTick
import com.market.stream.mapper.asPriceTickList
import com.market.stream.remote.model.AssetDataApiResponse
import com.market.stream.remote.source.AssetDataRemoteSource
import com.market.stream.tick.PriceTick
import com.market.stream.websocket.source.AssetDataWebSocketSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import timber.log.Timber
import javax.inject.Inject

// TODO handle errors and throw valid exceptions if any...
class AssetDataRepositoryImpl @Inject constructor(
    private val webSocketSource: AssetDataWebSocketSource,
    private val remoteSource: AssetDataRemoteSource,
    private val localSource: AssetDataLocalSource
) : AssetDataRepository {

    override fun getAssetData(symbol: String): Flow<List<PriceTick>> =
        remoteSource.getAssetData(symbol)
            .map(AssetDataApiResponse::asPriceTickList)
            .onEach {
                Timber.d("We can save the list locally after mapping .. (Optional)")
                localSource
            }
            .onEach {
                Timber.d("We can check for response and throw any domain exceptions, to be caught in ui..")
                // throw DataAccessException.NetworkException()
            }

    override fun subscribeToAssetStream(symbol: String): Flow<PriceTick> =
        webSocketSource.subscribeToAssetStream(symbol)
            .map(RemotePriceTick::asPriceTick)
}