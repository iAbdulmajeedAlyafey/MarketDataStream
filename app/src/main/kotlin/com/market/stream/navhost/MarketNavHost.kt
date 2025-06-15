package com.market.stream.navhost

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.market.stream.AssetDetailsScreen
import com.market.stream.DashboardScreen
import com.market.stream.destination.Route

@Composable
fun MarketNavHost(
    modifier: Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Route.Dashboard.route
    ) {
        composable(route = Route.Dashboard.route) {
            DashboardScreen(
                navigateToAssetDetails = {
                    // TODO pass the selected asset..
                    navController.navigate(Route.AssetDetails.route)
                }
            )
        }
        composable(route = Route.AssetDetails.route) {
            AssetDetailsScreen()
        }
    }
}