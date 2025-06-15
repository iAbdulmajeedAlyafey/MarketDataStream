package com.market.stream.container

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.market.stream.navhost.MarketNavHost

@Composable
fun MarketContainer(
    navController: NavHostController = rememberNavController()
) {
    Surface {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            content = {
                MarketNavHost(
                    modifier = Modifier.padding(it),
                    navController = navController
                )
            }
        )
    }
}