package com.market.stream.di

import com.market.stream.local.source.AssetDataLocalSource
import com.market.stream.local.source.AssetDataLocalSourceImpl
import com.market.stream.remote.source.AssetDataRemoteSource
import com.market.stream.remote.source.AssetDataRemoteSourceImpl
import com.market.stream.websocket.source.AssetDataFakeWebSocketSourceImpl
import com.market.stream.websocket.source.AssetDataWebSocketSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface DataSourceModule {

    @Binds
    @Singleton
    fun bindAssetDataRemoteSource(source: AssetDataRemoteSourceImpl): AssetDataRemoteSource

    @Binds
    @Singleton
    fun bindAssetDataLocalSource(source: AssetDataLocalSourceImpl): AssetDataLocalSource

    @Binds
    @Singleton
    fun bindAssetWebSocketLocalSource(source: AssetDataFakeWebSocketSourceImpl): AssetDataWebSocketSource
}