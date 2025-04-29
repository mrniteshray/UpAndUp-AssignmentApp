package xcom.niteshray.xapps.assignmentapp.ui.screens.MonthScreen

// --- Imports ---
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import xcom.niteshray.xapps.assignmentapp.R

// --- Enum for Tabs ---
enum class PerformanceTab(val label: String, val iconRes: Int) {
    LATE("Late", R.drawable.late),
    UNIFORM("Uniform", R.drawable.uniform),
    GEOFENCE("Geofence", R.drawable.geofencing),
    ALERTNESS("Alertness", R.drawable.alertness),
    PATROL("Patrol", R.drawable.directions_walk)
}

@Composable
fun CalendarUI() {
    val tabs = PerformanceTab.values().toList()
    var selectedTab by remember { mutableStateOf(PerformanceTab.LATE) }

    // Map of <DayNumber, Tab> to Drawable Resource
    val calendarData = mapOf(
        Pair(7, PerformanceTab.LATE) to R.drawable.state_layer,
        Pair(9, PerformanceTab.LATE) to R.drawable.state_layer,
        Pair(20, PerformanceTab.LATE) to R.drawable.state_layer,
        Pair(5, PerformanceTab.LATE) to R.drawable.state_layer,
        Pair(6, PerformanceTab.UNIFORM) to R.drawable.state_layer,
        Pair(10, PerformanceTab.UNIFORM) to R.drawable.state_layer,
        Pair(15, PerformanceTab.UNIFORM) to R.drawable.state_layer,
        Pair(25, PerformanceTab.GEOFENCE) to R.drawable.state_layer,
        Pair(27, PerformanceTab.ALERTNESS) to R.drawable.state_layer,
        Pair(28, PerformanceTab.ALERTNESS) to R.drawable.state_layer,
        Pair(29, PerformanceTab.ALERTNESS) to R.drawable.state_layer,
        Pair(1, PerformanceTab.PATROL) to R.drawable.state_layer,
        Pair(12, PerformanceTab.PATROL) to R.drawable.state_layer,
        Pair(18, PerformanceTab.PATROL) to R.drawable.state_layer,
    )

    val daysInMonth = (1..31).toList()
    val weeks = daysInMonth.chunked(7)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .background(Color(0xFFEFF1F5).copy(0.6f), RoundedCornerShape(16.dp))
            .padding(8.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            tabs.forEach { tab ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .background(
                            if (tab == selectedTab) Color(0xFF4A5C3D) else Color.White,
                            RoundedCornerShape(8.dp)
                        )
                        .clickable { selectedTab = tab }
                        .padding(horizontal = 10.dp, vertical = 6.dp)
                ) {
                    Icon(
                        painter = painterResource(id = tab.iconRes),
                        contentDescription = tab.label,
                        tint = if (tab == selectedTab) Color.White else Color.Black,
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = "03", // Replace with actual count if dynamic
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (tab == selectedTab) Color.White else Color.Black
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // --- Weekday Row ---
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            listOf("M", "T", "W", "T", "F", "S", "S").forEach { day ->
                Text(
                    text = day,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // --- Calendar Grid ---
        weeks.forEach { week ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                week.forEach { day ->
                    val key = Pair(day, selectedTab)
                    val icon = calendarData[key]

                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(48.dp)
                            .background(Color.White, shape = CircleShape)
                    ) {
                        if (icon != null) {
                            Image(
                                painter = painterResource(id = icon),
                                contentDescription = "Icon on $day",
                                modifier = Modifier.size(36.dp)
                            )
                        } else {
                            Text(
                                text = "$day",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color.Black
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
