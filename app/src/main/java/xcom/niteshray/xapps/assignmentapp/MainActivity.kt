package xcom.niteshray.xapps.assignmentapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import xcom.niteshray.xapps.assignmentapp.navigation.App
import xcom.niteshray.xapps.assignmentapp.ui.theme.AssignmentAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AssignmentAppTheme {
                val navController = rememberNavController()
                App(navController)
            }
        }
    }
}
