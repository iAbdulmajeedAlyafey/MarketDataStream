package com.market.stream

sealed class AssetDetailsAction {
    data object GetDetails : AssetDetailsAction()
}
