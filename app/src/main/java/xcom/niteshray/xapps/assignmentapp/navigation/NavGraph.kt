package xcom.niteshray.xapps.assignmentapp.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import xcom.niteshray.xapps.assignmentapp.ui.screens.DayScreen.DayScreen
import xcom.niteshray.xapps.assignmentapp.ui.screens.HomeScreen
import xcom.niteshray.xapps.assignmentapp.ui.screens.MonthScreen.MonthScreen
import xcom.niteshray.xapps.assignmentapp.ui.screens.WeekScreen.WeekScreen

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object Day : Screen("day_screen")
    object Week : Screen("week_screen")
    object Month : Screen("month_screen")
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun App(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(Screen.Day.route) { DayScreen(navController) }
        composable(Screen.Week.route) { WeekScreen(navController) }
        composable(Screen.Month.route) { MonthScreen(navController) }
    }
}
