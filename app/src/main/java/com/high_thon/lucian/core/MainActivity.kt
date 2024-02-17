package com.high_thon.lucian.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.high_thon.lucian.common.theme.LucianTheme
import com.high_thon.lucian.feature.alarm.AlarmScreen
import com.high_thon.lucian.feature.alarm.viewmodel.AlarmViewModel
import dagger.hilt.android.AndroidEntryPoint

enum class LucianPage(val value: String) {
    Alarm("alarm")
}
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavController

    private val alarmViewModel by viewModels<AlarmViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()

            LucianTheme { _, _ ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .navigationBarsPadding()
                ) {
                    NavHost(
                        navController = navController as NavHostController,
                        startDestination = LucianPage.Alarm.name
                    ) {
                        composable(LucianPage.Alarm.name) {
                            AlarmScreen(
                                context = this@MainActivity,
                                viewModel = alarmViewModel
                            )
                        }
                    }
                }
            }
        }
    }
}