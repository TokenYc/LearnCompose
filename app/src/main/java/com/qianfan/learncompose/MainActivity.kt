package com.qianfan.learncompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.qianfan.learncompose.compose.MainPage
import com.qianfan.learncompose.compose.StartPage
import com.qianfan.learncompose.theme.ComposeDemoTheme
import com.samluys.statusbar.StatusBarUtils

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtils.transparencyBar(this)
        StatusBarUtils.StatusBarIconDark(this)
        setContent {
            ProvideWindowInsets {
                ComposeDemoTheme {
                    page()
                }
            }
        }
    }

    @Composable
    fun page() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "main") {

            composable("start") {
                StartPage(navController)
            }

            composable("main") {
                MainPage(navController)
            }
        }

    }
}