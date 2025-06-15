package com.market.stream.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.market.stream.container.MarketContainer
import com.market.stream.theme.MarketTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MarketActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarketTheme {
                MarketContainer()
            }
        }
    }
}
