package com.market.stream.local.source

import com.market.stream.local.model.CachedAssetData
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

// TODO complete...
class AssetDataLocalSourceImpl @Inject constructor(
    // private val dataDao: AssetDataDao
) : AssetDataLocalSource {

    override fun getAssetDetails(symbol: String) = flow {
        emit(emptyList<CachedAssetData>())
    }

    override fun saveAssetDataList(data: List<CachedAssetData>) = Unit

    // TODO We can save price tick one at a time (when we get from websocket),
    //  or save entire list (after initial load)... Needs to think about logic..
}