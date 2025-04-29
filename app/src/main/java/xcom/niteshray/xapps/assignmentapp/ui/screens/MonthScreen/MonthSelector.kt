package xcom.niteshray.xapps.assignmentapp.ui.screens.MonthScreen

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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate
import java.time.Month
import xcom.niteshray.xapps.assignmentapp.R

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MonthSelectorUI(selectedYear: Int = LocalDate.now().year) {
    val currentDate = LocalDate.now()
    val currentMonth = currentDate.month
    val currentYear = currentDate.year

    // All 12 months for the given year
    val monthsWithYears = Month.values().map { it to selectedYear }

    var selectedMonth by remember {
        mutableStateOf(
            if (selectedYear == currentYear) {
                monthsWithYears.find { it.first == currentMonth } ?: monthsWithYears.first()
            } else {
                monthsWithYears.first()
            }
        )
    }

    Row(
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
            .horizontalScroll(rememberScrollState()),
        verticalAlignment = Alignment.CenterVertically
    ) {
        monthsWithYears.forEach { (month, year) ->
            val isSelected = selectedMonth == Pair(month, year)

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .background(
                        if (isSelected) Color(0xFF4A5C3D) else Color.White
                        , RoundedCornerShape(8.dp)
                    )
                    .clickable { selectedMonth = Pair(month, year) }
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(
                    text = month.name.take(3),
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = if (isSelected) Color.White else Color(0xFF3F3F3F)
                )
                Text(
                    text = year.toString(),
                    fontSize = 12.sp,
                    color = if (isSelected) Color.White else Color(0xFF777777)
                )
            }
        }

        Spacer(modifier = Modifier.width(8.dp))

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.White, shape = CircleShape)
                .padding(8.dp),
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
