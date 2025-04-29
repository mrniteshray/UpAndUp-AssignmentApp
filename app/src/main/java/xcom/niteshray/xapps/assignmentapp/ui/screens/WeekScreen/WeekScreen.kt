package xcom.niteshray.xapps.assignmentapp.ui.screens.WeekScreen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import xcom.niteshray.xapps.assignmentapp.R
import xcom.niteshray.xapps.assignmentapp.ui.screens.DayScreen.DateSelector
import xcom.niteshray.xapps.assignmentapp.ui.screens.DayScreen.IconTab
import xcom.niteshray.xapps.assignmentapp.ui.screens.DayScreen.PerformanceTab
import xcom.niteshray.xapps.assignmentapp.ui.screens.DayScreen.ProfileSection
import xcom.niteshray.xapps.assignmentapp.ui.screens.DayScreen.cardView
import xcom.niteshray.xapps.assignmentapp.ui.theme.PrimaryColor
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAdjusters

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeekScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_img), // same background
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp)
                .align(Alignment.TopCenter)
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back), // back arrow image
                        contentDescription = "Back",
                        modifier = Modifier.size(36.dp),
                        tint = PrimaryColor
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "PERFORMANCE",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryColor,
                    modifier = Modifier.weight(1f),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
            }
            ProfileSection()
            WeekSelector()
            PerformanceGridUI()
        }
    }
}
enum class PerformanceTab {
    LATE ,UNIFORM, GEOFENCE, ALERTNESS , Patrol
}

@Composable
fun PerformanceGridUI() {
    val tabs = listOf("LATE", "UNIFORM", "GEORFENCE", "ALUMNUS", "FIELD TASKS")
    var selectedTab by remember { mutableStateOf(PerformanceTab.GEOFENCE) }

    val performanceTabIndexMap = mapOf(
        PerformanceTab.LATE to 0,
        PerformanceTab.UNIFORM to 1,
        PerformanceTab.GEOFENCE to 2,
        PerformanceTab.ALERTNESS to 3,
        PerformanceTab.Patrol to 4
    )

    val days = listOf("M", "T", "W", "T", "F", "S", "S")

    // Dummy data [row = day, column = tab]
    val dummyData = mapOf(
        Pair(0, 0) to true,
        Pair(1, 0) to true,
        Pair(2, 1) to true,
        Pair(3, 2) to true,
        Pair(4, 3) to true,
        Pair(5, 3) to true,
        Pair(6, 4) to true
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .background(
                color = Color.White.copy(alpha = 0.4f),
                shape = RoundedCornerShape(24.dp)
            )
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Tabs
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconTab(
                painterResource(id = R.drawable.late),
                isSelected = selectedTab == PerformanceTab.LATE
            ) {
                selectedTab = PerformanceTab.LATE
            }
            IconTab(
                painterResource(id = R.drawable.uniform),
                isSelected = selectedTab == PerformanceTab.UNIFORM
            ) {
                selectedTab = PerformanceTab.UNIFORM
            }
            IconTab(
                painterResource(id = R.drawable.geofencing),
                isSelected = selectedTab == PerformanceTab.GEOFENCE
            ) {
                selectedTab = PerformanceTab.GEOFENCE
            }
            IconTab(
                painterResource(id = R.drawable.alertness),
                isSelected = selectedTab == PerformanceTab.ALERTNESS
            ) {
                selectedTab = PerformanceTab.ALERTNESS
            }
            IconTab(
                painterResource(id = R.drawable.directions_walk),
                isSelected = selectedTab == PerformanceTab.Patrol
            ) {
                selectedTab = PerformanceTab.Patrol
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Grid
        Column {
            days.forEachIndexed { rowIndex, day ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Day label
                    Text(
                        text = day,
                        modifier = Modifier.width(20.dp),
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(8.dp))

                    // Tab columns
                    tabs.forEachIndexed { colIndex, _ ->
                        val isSelectedColumn = performanceTabIndexMap[selectedTab] == colIndex
                        val hasCircle = dummyData[Pair(rowIndex, colIndex)] == true

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(48.dp)
                                .background(
                                    if (isSelectedColumn) Color(0xFFEAEAEA) else Color.Transparent,
                                    shape = RoundedCornerShape(4.dp)
                                )
                                .border(1.dp, Color.LightGray),
                            contentAlignment = Alignment.Center
                        ) {
                            if (isSelectedColumn && hasCircle) {
                                Image(
                                    painter = painterResource(R.drawable.state_layer),
                                    contentDescription = "Circle Indicator",
                                    modifier = Modifier.size(32.dp)
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(6.dp))
            }
        }
    }
}


