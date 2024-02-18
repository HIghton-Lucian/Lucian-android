package com.high_thon.lucian.core

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.high_thon.lucian.common.component.LucianBottomNavigation
import com.high_thon.lucian.common.theme.LucianTheme
import com.high_thon.lucian.feature.alarm.Alarm1
import com.high_thon.lucian.feature.alarm.Alarm2
import com.high_thon.lucian.feature.alarm.Alarm3
import com.high_thon.lucian.feature.alarm.Alarm4
import com.high_thon.lucian.feature.alarm.AlarmScreen
import com.high_thon.lucian.feature.alarm.AlarmSettingScreen
import com.high_thon.lucian.feature.alarm.viewmodel.AlarmViewModel
import com.high_thon.lucian.feature.calendar.CalendarScreen
import com.high_thon.lucian.feature.calendar.CalendarViewModel
import com.high_thon.lucian.feature.diary.DiaryAfterScreen
import com.high_thon.lucian.feature.diary.DiaryScreen
import com.high_thon.lucian.feature.dild.DildScreen
import com.high_thon.lucian.feature.home.HomeScreen
import com.high_thon.lucian.feature.home.result.HomeResultScreen
import com.high_thon.lucian.feature.home.result.viewmodel.HomeResultViewModel
import com.high_thon.lucian.feature.home.viewmodel.HomeViewModel
import com.high_thon.lucian.feature.rc.RcScreen
import com.high_thon.lucian.feature.sleep.SleepScreen
import dagger.hilt.android.AndroidEntryPoint

enum class LucianPage(val value: String) {
    Calendar("calendar"),
    Home("Home"),
    HomeResult("Home/{keyword}"),
    AlarmSetting("AlarmSetting"),
    Dild("Dild")
}

enum class SleepPage(val value: String) {
    Sleep("Sleep"),
    Rc("Rc"),
    Alarm("Alarm"),
    Diary("Diary"),
    AfterDiary("After")
}
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavController

    private val alarmViewModel by viewModels<AlarmViewModel>()
    private val calendarViewModel by viewModels<CalendarViewModel>()
    private val homeViewModel by viewModels<HomeViewModel>()
    private val homeResultViewModel by viewModels<HomeResultViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            LucianTheme { _, _ ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .systemBarsPadding(),
                ) {
                    NavHost(
                        navController = navController as NavHostController,
                        startDestination = LucianPage.Home.name
                    ) {
                        composable(LucianPage.Home.name) {
                            Log.d("testt", currentRoute.toString())
                            HomeScreen(
                                navController = navController as NavHostController,
                                viewModel = homeViewModel,
                                onSleepClick = { navController.navigate(SleepPage.Diary.name) }
                            )
                        }

                        composable(
                            route = LucianPage.HomeResult.value,
                            arguments = listOf(
                                navArgument("keyword") {
                                    type = NavType.StringType
                                }
                            )
                        ) { entry ->
                            val keyword = entry.arguments?.getString("keyword")
                            if (keyword != null) {
                                HomeResultScreen(
                                    navController = navController,
                                    viewModel = homeResultViewModel,
                                    keyword = keyword
                                )
                            }
                        }

                        composable(SleepPage.Alarm.name) {
                            AlarmScreen(
                                onClick = { navController.navigate(SleepPage.AfterDiary.name)}
                            )
                        }
                        composable(SleepPage.AfterDiary.name) {
                            DiaryAfterScreen {
                                navController.navigate(LucianPage.Calendar.name)
                            }
                        }

                        composable(LucianPage.AlarmSetting.name) {
                            Log.d("testt",currentRoute.toString())
                            AlarmSettingScreen(
                                context = this@MainActivity,
                                viewModel = alarmViewModel,
                                navController = navController as NavHostController,
                                onClick = {}
                            )
                        }

                        composable(SleepPage.Sleep.name) {
                            SleepScreen {
                                navController.navigate(SleepPage.Rc.name)
                            }
                        }
                        composable(SleepPage.Rc.name) {
                            RcScreen(onClick = {navController.navigate(Alarm.Alarm1.name)})
                        }

                        composable(LucianPage.Dild.name) {
                            DildScreen(
                                navController = navController as NavHostController,
                            )
                        }

                        composable(LucianPage.Calendar.name) {
                            CalendarScreen(
                                viewModel = calendarViewModel,
                            )
                        }

                        composable(LucianPage.Dild.name) {
                            DildScreen(
                                navController = navController as NavHostController,
                            )
                        }
                        composable(Alarm.Alarm1.name) {
                            Alarm1 {
                                navController.navigate(Alarm.Alarm2.name)
                            }
                        }
                        composable(Alarm.Alarm2.name) {
                            Alarm2 {
                                navController.navigate(Alarm.Alarm3.name)
                            }
                        }
                        composable(Alarm.Alarm3.name) {
                            Alarm3 {
                                navController.navigate(Alarm.Alarm4.name)
                            }
                        }
                        composable(Alarm.Alarm4.name) {
                            Alarm4 {
                                navController.navigate(SleepPage.Sleep.name)
                            }
                        }
                        composable(SleepPage.Diary.name) {
                            DiaryScreen {
                                navController.navigate(SleepPage.Rc.name)
                            }
                        }
                    }

                    LucianBottomNavigation(
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .align(Alignment.BottomCenter),
                        isVisible = currentRoute in LucianPage.values().map { it.name },
                        currentRoute = currentRoute ?: "Home",
                        onHomeClick = { navController.navigate(LucianPage.Home.name) },
                        onCalenderClick = { navController.navigate(LucianPage.Calendar.name) },
                        onAlarmClick = { navController.navigate(LucianPage.AlarmSetting.name) },
                        onSettingClick = { navController.navigate(SleepPage.Alarm.name) }
                    )
                }
            }
        }
    }
}


enum class Alarm(val value: String) {
    Alarm1("Alarm1"),
    Alarm2("Alarm2"),
    Alarm3("Alarm3"),
    Alarm4("Alarm4"),
}