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
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.google.accompanist.insets.statusBarsPadding
import com.qianfan.learncompose.R

@Composable
fun TopBar(tabName: String) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .statusBarsPadding()
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
                    painter = rememberImagePainter(
                        data = "https://img2.baidu.com/it/u=1429175118,2649084526&fm=26&fmt=auto",
                        builder = {
                            transformations(CircleCropTransformation())
                            crossfade(300)
                            placeholder(R.mipmap.icon_default_avatar)
                        }),
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
        Surface(
            color = Color.White, modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {

        }

    }
}