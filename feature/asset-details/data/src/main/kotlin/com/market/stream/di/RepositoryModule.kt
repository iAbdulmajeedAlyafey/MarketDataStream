package com.market.stream.di

import com.market.stream.repository.AssetDataRepository
import com.market.stream.repository.AssetDataRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindAssetDataRepository(repository: AssetDataRepositoryImpl): AssetDataRepository
}