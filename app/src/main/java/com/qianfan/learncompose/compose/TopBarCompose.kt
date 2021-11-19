package com.qianfan.learncompose.compose

import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.google.accompanist.insets.statusBarsPadding
import com.qianfan.learncompose.R

@Composable
fun TopBar(
    tabName: String, painter: ImagePainter
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(MaterialTheme.colors.primary)
    ) {
        Row(
            Modifier
                .fillMaxHeight()
                .wrapContentWidth()
                .align(Alignment.CenterStart), verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(15.dp)
            )
            Image(
                painter = painter,
                null,
                modifier = Modifier
                    .size(34.dp)
            )
        }


        Text(
            text = tabName,
            modifier = Modifier
                .align(Alignment.Center),
            fontSize = 20.sp,
            color = Color.White
        )
    }

}