package com.market.stream.destination

// TODO Add more routes here as needed, or migrate to use Navigation 3
sealed class Route(val route: String) {
    data object AssetDetails : Route("asset-details")
    data object Dashboard : Route("dashboard")
}