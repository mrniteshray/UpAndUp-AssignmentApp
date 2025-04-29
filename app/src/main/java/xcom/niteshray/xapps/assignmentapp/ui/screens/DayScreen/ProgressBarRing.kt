package xcom.niteshray.xapps.assignmentapp.ui.screens.DayScreen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.Stroke


@Composable
fun SegmentedProgressRing(
    modifier: Modifier = Modifier,
    sweepAngle: Float, // Red segment angle
    ringColor: Color = Color(0xFFFF6D6D), // Default red color
    innerContent: @Composable ColumnScope.() -> Unit
) {
    Box(
        modifier = modifier.size(200.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.matchParentSize()) {
            val center = Offset(size.width / 2, size.height / 2)
            val radius = size.width / 2
            val strokeWidth = 14.dp.toPx() // Thickness of the ring

            //Full base circle - light gray
            drawArc(
                color = Color(0xFFF0F0F0),
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = false,
                topLeft = Offset(center.x - radius, center.y - radius),
                size = size,
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
            )

            // Highlighted red segment
            drawArc(
                color = ringColor,
                startAngle = 0f, // Adjust this if segment needs to start elsewhere
                sweepAngle = sweepAngle,
                useCenter = false,
                topLeft = Offset(center.x - radius, center.y - radius),
                size = size,
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
            )

            //Black tick line at the top
            drawLine(
                color = Color.Black,
                start = Offset(center.x, center.y - radius),
                end = Offset(center.x, center.y - radius - 12.dp.toPx()),
                strokeWidth = 3.dp.toPx()
            )
        }

        // Slot for center icon and text
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            content = innerContent
        )
    }
}
