package com.market.stream

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.market.stream.tick.PriceTick
import com.market.stream.usecase.GetAssetDataUseCase
import com.market.stream.usecase.SubscribeToAssetStreamUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import timber.log.Timber
import javax.inject.Inject

// TODO complete logic and injecting dependencies like args and dispatchers...
@HiltViewModel
class AssetDetailsViewModel @Inject constructor(
    val getAssetDataUseCase: GetAssetDataUseCase,
    val subscribeToAssetStreamUseCase: SubscribeToAssetStreamUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(AssetDetailsUiState())
    val uiState = _uiState.asStateFlow()

    fun handleAction(action: AssetDetailsAction) {
        when (action) {
            is AssetDetailsAction.GetDetails -> getAssetDetails()
        }
    }

    // TODO symbol is hardcoded for demo, also handle exceptions..
    @OptIn(ExperimentalCoroutinesApi::class)
    private fun getAssetDetails(symbol: String = "AAPL") = getAssetDataUseCase(symbol)
        .onEach { handleAssetDetails(it) }
        .flatMapLatest { subscribeToAssetStreamUseCase(symbol) }
        .onEach { handleAssetStream(it) }
        .catch { handleExceptions(it) }
        .flowOn(Dispatchers.IO)
        .launchIn(viewModelScope)

    private fun handleExceptions(throwable: Throwable) {
        Timber.e("Exception is ${throwable.message}")
    }

    private fun handleAssetDetails(list: List<PriceTick>) = _uiState.update {
        // Emit initial data...
        Timber.d("Initial data is here.. $list")
        it.copy(
            symbol = list.first().symbol,
            history = list,
            loading = false
        )
    }

    private fun handleAssetStream(priceTick: PriceTick) {
        // TODO do the logic to post this tick, EFFICIENTLY considering throttling..
        //  this is for demo purpose ..
        Timber.d("New tick is here ... $priceTick")
        _uiState.update {
            it.copy(history = it.history + priceTick)
        }
    }
}