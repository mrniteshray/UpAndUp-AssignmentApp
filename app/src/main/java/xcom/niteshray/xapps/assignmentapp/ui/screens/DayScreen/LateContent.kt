package xcom.niteshray.xapps.assignmentapp.ui.screens.DayScreen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import xcom.niteshray.xapps.assignmentapp.R
import xcom.niteshray.xapps.assignmentapp.ui.theme.blue
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import kotlin.math.min

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LateIndicator(delayMinutes: Int) {
    // Use LocalTime to get the current time
    val currentTime = LocalTime.now()
    val formattedTime = currentTime.format(DateTimeFormatter.ofPattern("hh:mm a"))

    // Calculate the late percentage (clamp between 0 and 100)
    val latePercentage = min(delayMinutes, 60).toFloat() / 60f  // Max 60 minutes for the indicator
    val sweepAngle = latePercentage * 360f

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        // Background circle
        SegmentedProgressRing(sweepAngle = sweepAngle) { // adjust angle as needed
            Icon(
                painter = painterResource(id = R.drawable.late),
                contentDescription = null,
                tint = blue,
                modifier = Modifier.size(36.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "LATE",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = blue
            )
        }

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "$formattedTime - ${delayMinutes} MIN. LATE",
            style = TextStyle(
                color = blue,
                fontSize = 16.sp, // Increased font size
                fontWeight = FontWeight.Normal
            ),
            modifier = Modifier.padding(top = 220.dp) // Adjusted top padding
        )
    }
}
