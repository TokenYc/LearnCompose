package com.qianfan.learncompose.compose

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

@Composable
fun ForumPage(navController: NavController,painter: ImagePainter) {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        TopBar("社区",painter)
    }
}