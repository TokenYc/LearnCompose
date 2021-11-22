package com.qianfan.learncompose.compose.pai

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import coil.compose.ImagePainter
import com.google.accompanist.insets.statusBarsPadding
import com.qianfan.learncompose.compose.TopBar

@Composable
fun PaiPage(navController: NavController, painter: ImagePainter) {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        TopBar("巷友圈", painter)
    }
}