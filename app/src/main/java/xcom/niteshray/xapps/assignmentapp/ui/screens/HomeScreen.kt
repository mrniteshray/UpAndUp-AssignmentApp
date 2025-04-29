package xcom.niteshray.xapps.assignmentapp.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import xcom.niteshray.xapps.assignmentapp.R
import xcom.niteshray.xapps.assignmentapp.navigation.Screen
import xcom.niteshray.xapps.assignmentapp.ui.theme.PrimaryColor

@Composable
fun HomeScreen(
    navController: NavController,
) {
    val context = LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_img),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Foreground Card
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .align(Alignment.Center)
                .background(
                    color = Color.White.copy(alpha = 0.4f),
                    shape = RoundedCornerShape(24.dp)
                )
                .padding(24.dp)
            ,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Title + Close Icon
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "SELECT CALENDAR VIEW",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryColor
                )
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(R.drawable.close),
                    contentDescription = "close",
                    modifier = Modifier
                        .size(36.dp)
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Buttons
            CalendarOptionButton( painterResource(R.drawable.calendar_view_day),text = " DAY", onClick = {
                navController.navigate(Screen.Day.route)
            })
            Spacer(modifier = Modifier.height(16.dp))
            CalendarOptionButton(painterResource(R.drawable.calendar_view_week),text = "WEEK", onClick = {
                navController.navigate(Screen.Week.route)
            })
            Spacer(modifier = Modifier.height(16.dp))
            CalendarOptionButton(painterResource(R.drawable.calendar_view_month),text = "MONTH", onClick = {
                Toast.makeText(context, "null", Toast.LENGTH_SHORT).show()
            })
        }
    }
}

@Composable
fun CalendarOptionButton( painter: Painter, text: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .shadow(4.dp, shape = RoundedCornerShape(16.dp))
            .background(Color.White, shape = RoundedCornerShape(16.dp))
            .clickable { onClick() }
            .size(width = 160.dp, height = 120.dp)
        ,
        contentAlignment = Alignment.Center
    ) {
        Column {
            Image(
                painter = painter,
                contentDescription = "Calendar",
                modifier = Modifier
                    .size(40.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = text,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = PrimaryColor
            )
        }
    }
}
