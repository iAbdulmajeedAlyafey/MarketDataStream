package com.market.stream.components.chart

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.math.BigDecimal

/**
 * A simple line chart with X and Y axes and labels for demo purposes.
 *
 * Final composable should be fully tested in terms of performance.
 */
@Composable
fun LineChart(
    data: List<BigDecimal>,
    modifier: Modifier = Modifier,
    axisColor: Color = Color.Black,
    lineColor: Color = Color(0xFF4CAF50),
    strokeWidth: Dp = 2.dp,
    labelTextStyle: TextStyle = TextStyle(fontSize = 12.sp),
    horizontalLabelCount: Int = minOf(5, data.size),
    vertLabelCount: Int = 5,
    padding: Dp = 16.dp
) {
    if (data.isEmpty()) return

    val floatData = data.map { it.toFloat() }
    Canvas(
        modifier = modifier
            .height(200.dp)
            .padding(padding)
    ) {
        val w = size.width
        val h = size.height
        val bottom = h

        // draw axes
        drawLine(
            color = axisColor,
            start = Offset(0f, 0f),
            end = Offset(0f, h),
            strokeWidth = strokeWidth.toPx()
        )
        drawLine(
            color = axisColor,
            start = Offset(0f, bottom),
            end = Offset(w, bottom),
            strokeWidth = strokeWidth.toPx()
        )

        // find range
        val maxY = floatData.maxOrNull() ?: 0f
        val minY = floatData.minOrNull() ?: 0f
        val yRange = (maxY - minY).coerceAtLeast(0.1f)
        val xStep = w / (floatData.size - 1).coerceAtLeast(1)

        // draw data line
        val path = Path().apply {
            floatData.forEachIndexed { i, value ->
                val x = i * xStep
                val yRatio = (value - minY) / yRange
                val y = bottom - (yRatio * h)
                if (i == 0) moveTo(x, y) else lineTo(x, y)
            }
        }
        drawPath(
            path = path,
            color = lineColor,
            style = Stroke(
                width = strokeWidth.toPx(),
                cap = StrokeCap.Round,
                join = StrokeJoin.Round
            )
        )

        // prepare Paint for text
        val paint = Paint().apply {
            isAntiAlias = true
            textSize = labelTextStyle.fontSize.toPx()
            color = axisColor.toArgb()
            textAlign = Paint.Align.CENTER
        }

        // draw Y-axis labels
        repeat(vertLabelCount) { idx ->
            val fraction = idx.toFloat() / (vertLabelCount - 1)
            val y = bottom - (fraction * h)
            // tick
            drawLine(
                color = axisColor,
                start = Offset(-4.dp.toPx(), y),
                end = Offset(0f, y),
                strokeWidth = strokeWidth.toPx()
            )
            // label
            val label = String.format("%.1f", minY + (yRange * fraction))
            drawContext.canvas.nativeCanvas.drawText(
                label,
                -8.dp.toPx() - paint.measureText(label),
                y + (paint.textSize / 2),
                paint
            )
        }

        // draw X-axis labels
        repeat(horizontalLabelCount) { idx ->
            val fraction = idx.toFloat() / (horizontalLabelCount - 1)
            val x = fraction * w
            // tick
            drawLine(
                color = axisColor,
                start = Offset(x, bottom),
                end = Offset(x, bottom + 4.dp.toPx()),
                strokeWidth = strokeWidth.toPx()
            )
            // label
            val dataIndex = (fraction * (floatData.size - 1)).toInt()
            val label = dataIndex.toString()
            drawContext.canvas.nativeCanvas.drawText(
                label,
                x,
                bottom + 12.dp.toPx() + paint.textSize,
                paint
            )
        }
    }
}