package com.qianfan.learncompose.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.ImagePainter
import com.google.accompanist.insets.statusBarsPadding
import com.qianfan.learncompose.theme.Divider

@Composable
fun HomePage(navController: NavController,painter: ImagePainter) {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        TopBar("化龙巷",painter)
    }
}