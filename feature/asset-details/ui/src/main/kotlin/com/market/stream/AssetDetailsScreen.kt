package com.market.stream

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.market.stream.components.chart.LineChart

@Composable
fun AssetDetailsScreen(
    viewModel: AssetDetailsViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    LifecycleEventEffect(Lifecycle.Event.ON_CREATE) {
        viewModel.handleAction(AssetDetailsAction.GetDetails)
    }
    when {
        uiState.loading -> ScreenLoader()
        uiState.history.isNotEmpty() -> ScreenContent(uiState = uiState)
        else -> NoDataView()
    }
}

@Composable
private fun ScreenContent(
    modifier: Modifier = Modifier,
    uiState: AssetDetailsUiState
) {
    Column(modifier = modifier.fillMaxSize()) {
        Text(
            text = uiState.symbol.orEmpty(),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
        )
        LineChart(
            data = uiState.history.map { it.price },
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )
    }
}

@Composable
private fun ScreenLoader(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}


@Composable
private fun NoDataView(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("No data available")
    }
}

@Preview
@Composable
private fun ScreenContentPreview(modifier: Modifier = Modifier) {
    ScreenContent(
        uiState = AssetDetailsUiState()
    )
}