package com.market.stream.tick

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

/**
 * Data model for a tick in the price stream.
 * @param symbol The asset name.
 * @param timestamp Time of the tick (epoch millis or Instant).
 * @param price The price value of this tick.
 */
@Parcelize
data class PriceTick(
    val symbol: String,
    val timestamp: Long,
    val price: BigDecimal
) : Parcelable
