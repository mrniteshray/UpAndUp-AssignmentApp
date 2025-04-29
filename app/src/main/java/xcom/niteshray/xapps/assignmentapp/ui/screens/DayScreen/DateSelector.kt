package xcom.niteshray.xapps.assignmentapp.ui.screens.DayScreen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DateSelector() {
    val today = LocalDate.now()
    val dates = remember { generateDates(today) }
    var selectedDate by remember { mutableStateOf(today) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .height(100.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFFEDEDED), Color(0xFFD9D9D9))
                ),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(8.dp)
        ,
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(start = 16.dp, end = 72.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            dates.forEach { date ->
                DateCard(
                    date = date,
                    isSelected = selectedDate == date,
                    onClick = { selectedDate = date }
                )
            }
        }
        Box(
            modifier = Modifier
                .padding(end = 16.dp)
                .align(Alignment.CenterEnd)
                .size(65.dp)
                .background(Color.White , CircleShape)
                .clickable { /* TODO: Open date picker */ },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.DateRange,
                contentDescription = "Calendar",
                tint = Color(0xFF5D5D29),
                modifier = Modifier.size(45.dp)
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DateCard(date: LocalDate, isSelected: Boolean, onClick: () -> Unit) {
    val backgroundColor = if (isSelected) Color(0xFF5D5D29) else Color.White
    val textColor = if (isSelected) Color.White else Color(0xFF5D5D29)

    Column(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(backgroundColor)
            .clickable(onClick = onClick)
            .padding(vertical = 16.dp, horizontal = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = date.dayOfMonth.toString(),
            fontSize = 16.sp,
        )
        Text(
            text = date.month.getDisplayName(TextStyle.SHORT, Locale.ENGLISH).uppercase(),
            fontSize = 12.sp
        )
        Text(
            text = date.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.ENGLISH).uppercase(),
            fontSize = 12.sp
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun generateDates(startDate: LocalDate, days: Long = 30): List<LocalDate> {
    return List(days.toInt()) { startDate.plusDays(it.toLong()) }
}