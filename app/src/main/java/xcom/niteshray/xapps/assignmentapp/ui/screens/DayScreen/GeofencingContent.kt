package xcom.niteshray.xapps.assignmentapp.ui.screens.DayScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import xcom.niteshray.xapps.assignmentapp.R
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import xcom.niteshray.xapps.assignmentapp.ui.theme.blue

@Composable
fun GeofenceContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        SegmentedProgressRing(sweepAngle = 45f) {
            Icon(
                painter = painterResource(id = R.drawable.geofencing), // Replace with your icon
                contentDescription = null,
                tint = Color(0xFF2E78E9),
                modifier = Modifier.size(36.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "GEOFENCE",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF2E78E9)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = { }) {
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape)
                        .background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "Previous",
                        tint = Color(0xFF999999)
                    )
                }
            }
            Spacer(modifier = Modifier.width(8.dp))

            Column{
                Text(
                    text = "10:23 PM TO 10:41 PM",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = blue
                )
                Text(
                    text = "18 MIN. OUTSIDE",
                    fontSize = 14.sp,
                    color = blue
                )
            }
            IconButton(onClick = { }) {
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "Next",
                        tint = Color(0xFF999999)
                    )
                }
            }
        }
    }
}