package com.market.stream

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// TODO Dummy screen for demo purpose..
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    navigateToAssetDetails: (String) -> Unit
) {
    val assets = listOf("AAPL", "GOOGL", "TSLA", "BTC")
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Dashboard") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            Text("Select an Asset:", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(16.dp))
            assets.forEach { asset ->
                Text(
                    text = asset,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))       // make it touchable
                        .clickable {
                            Log.d("DashboardScreen", "Clicked on: $asset") // ADD LOGGING HERE
                            navigateToAssetDetails(asset)
                        }
                        .padding(12.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
                HorizontalDivider()
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    DashboardScreen {}
}