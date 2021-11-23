package com.qianfan.learncompose.compose.pai

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import coil.compose.ImagePainter
import com.qianfan.learncompose.compose.widget.TopBar

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