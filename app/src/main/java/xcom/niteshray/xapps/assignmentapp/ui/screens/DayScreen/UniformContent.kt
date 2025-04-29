package xcom.niteshray.xapps.assignmentapp.ui.screens.DayScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import xcom.niteshray.xapps.assignmentapp.R
import xcom.niteshray.xapps.assignmentapp.ui.theme.blue
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults

@Composable
fun UniformContent() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().background(Color.Transparent) // Transparent background for the whole column
    ) {
        Icon(
            painter = painterResource(id = R.drawable.uniform),
            contentDescription = "Uniform Icon",
            tint = blue,
            modifier = Modifier.size(30.dp)
        )
        Text(
            text = "Uniform",
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = blue // Assuming 'blue' is defined elsewhere
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        UniformList(uniformItems = listOf(
            UniformItem(painterResource(id = R.drawable.uniform_hat), "CAP MISSING"),
            UniformItem(painterResource(id = R.drawable.uniform_shoe), "WRONG SHOES"),
            UniformItem(painterResource(id = R.drawable.id_card), "ID MISSING"),
            UniformItem(painterResource(id = R.drawable.uniform_torch), "TORCH MISSING")
        ))
    }
}

data class UniformItem(val painter: Painter, val title: String)

@Composable
fun UniformList(uniformItems: List<UniformItem>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp) // Add horizontal padding for the list
    ) {
        items(uniformItems) { item ->
            UniformListItem(item = item)
        }
    }
}

@Composable
fun UniformListItem(item: UniformItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .border(1.dp, Color.Gray, RoundedCornerShape(18.dp)),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor =  Color.Transparent
        )
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = item.painter,
                contentDescription = item.title,
                modifier = Modifier.size(20.dp)
            )
            Text(
                text = item.title ,
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = blue
                )
            )
            Image(
                painter = painterResource(id = R.drawable.gallery),
                contentDescription = "Gallery",
                modifier = Modifier.size(48.dp)
            )
        }
    }
}