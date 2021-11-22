package com.qianfan.learncompose.compose.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import coil.compose.ImagePainter
import com.qianfan.learncompose.compose.TopBar

@Composable
fun HomePage(navController: NavController, painter: ImagePainter) {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        TopBar(tabName = "首页", painter = painter)
        Grid()
    }
}

