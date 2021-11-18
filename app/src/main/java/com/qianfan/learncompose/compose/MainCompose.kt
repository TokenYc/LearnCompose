package com.qianfan.learncompose.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun MainPage(navController: NavController) {
    Box(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Text(
            text = "This is MainCompose",
            fontSize = 30.sp,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Preview
@Composable
fun previewMain() {
    val navController = rememberNavController()
    MainPage(navController = navController)
}