package xcom.niteshray.xapps.assignmentapp.ui.screens.DayScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import xcom.niteshray.xapps.assignmentapp.R
import xcom.niteshray.xapps.assignmentapp.ui.theme.blue

@Composable
fun AlertnessContent() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        SegmentedProgressRing(
            sweepAngle = 44f,
            ringColor = Color.Red
        ) {
            Icon(
                painter = painterResource(R.drawable.alertness),
                contentDescription = null,
                tint = blue,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "LOW ALERTNESS",
                fontSize = 12.sp,
                color = Color.Gray
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
                    text = "01:54 AM",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
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