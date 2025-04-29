package xcom.niteshray.xapps.assignmentapp.ui.screens.WeekScreen


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
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import java.time.format.DateTimeFormatter
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import xcom.niteshray.xapps.assignmentapp.R
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeekSelector() {
    val currentDate = LocalDate.now()
    val weeks = remember { generateWeekRanges(currentDate, 6) }
    var selectedWeek by remember { mutableStateOf(weeks[0]) }

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
            .padding(8.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(start = 16.dp, end = 72.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            weeks.forEach { week ->
                WeekCard(
                    start = week.first,
                    end = week.second,
                    isSelected = selectedWeek == week,
                    onClick = { selectedWeek = week }
                )
            }
        }

        Box(
            modifier = Modifier
                .padding(end = 16.dp)
                .align(Alignment.CenterEnd)
                .size(65.dp)
                .background(Color.White, CircleShape)
                .clickable { /* TODO: Open calendar */ },
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
fun WeekCard(start: LocalDate, end: LocalDate, isSelected: Boolean, onClick: () -> Unit) {
    val backgroundColor = if (isSelected) Color(0xFF5D5D29) else Color.White
    val textColor = if (isSelected) Color.White else Color(0xFF5D5D29)
    val dayFormatter = DateTimeFormatter.ofPattern("dd", Locale.ENGLISH)
    val monthFormatter = DateTimeFormatter.ofPattern("MMM", Locale.ENGLISH)

    val startDay = start.format(dayFormatter)
    val startMonth = start.format(monthFormatter).uppercase()
    val endDay = end.format(dayFormatter)
    val endMonth = end.format(monthFormatter).uppercase()

    Column(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(backgroundColor)
            .clickable { onClick() }
            .padding(vertical = 16.dp, horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "$startDay - $endDay",
            color = textColor,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Text(
            text = "$startMonth $endMonth",
            color = textColor,
            fontSize = 12.sp
        )
    }
}


@RequiresApi(Build.VERSION_CODES.O)
fun generateWeekRanges(startDate: LocalDate, numberOfWeeks: Int): List<Pair<LocalDate, LocalDate>> {
    val startOfWeek = startDate.with(DayOfWeek.MONDAY)
    return List(numberOfWeeks) { i ->
        val start = startOfWeek.plusWeeks(i.toLong())
        val end = start.plusDays(6)
        start to end
    }
}

