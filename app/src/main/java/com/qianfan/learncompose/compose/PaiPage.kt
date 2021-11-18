package com.qianfan.learncompose.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun PaiPage(navController: NavController) {
    Box(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(MaterialTheme.colors.primary)
    ) {
        TopBar("巷友圈")
    }
}