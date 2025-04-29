package xcom.niteshray.xapps.assignmentapp.ui.screens.DayScreen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import xcom.niteshray.xapps.assignmentapp.R
import xcom.niteshray.xapps.assignmentapp.ui.theme.PrimaryColor

// Define tabs
enum class PerformanceTab {
    LATE ,UNIFORM, GEOFENCE, ALERTNESS , Patrol
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DayScreen(navController: NavController) {

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
            DateSelector()
            Spacer(modifier = Modifier.height(10.dp))
            cardView()
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun cardView(){
    var selectedTab by remember { mutableStateOf(PerformanceTab.GEOFENCE) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .background(
                color = Color.White.copy(alpha = 0.4f),
                shape = RoundedCornerShape(24.dp)
            )
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Duty Start Time
        Text(
            text = "DUTY START TIME    08:00 PM",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = PrimaryColor
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Tabs (Icons)
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

        Spacer(modifier = Modifier.height(8.dp))

        // Middle Content based on selected tab
        when (selectedTab) {
            PerformanceTab.LATE -> { LateIndicator(5)}
            PerformanceTab.UNIFORM -> UniformContent()
            PerformanceTab.GEOFENCE -> GeofenceContent()
            PerformanceTab.ALERTNESS -> AlertnessContent()
            PerformanceTab.Patrol -> {}
        }
    }
}

@Composable
fun IconTab(icon: Painter, isSelected: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(48.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(6.dp))
            .background(if (isSelected) PrimaryColor else Color.White.copy(alpha = 0.5f))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = icon,
            contentDescription = "Tab Icon",
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun ProfileSection() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .background(Color.White.copy(alpha = 0.5f), RoundedCornerShape(16.dp))
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile), // user profile image
            contentDescription = "Profile",
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = "ID 234356",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = "Narayan Gupta",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = PrimaryColor
            )
        }
    }
}

