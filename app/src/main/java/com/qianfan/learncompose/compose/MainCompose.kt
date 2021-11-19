package com.qianfan.learncompose.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.statusBarsPadding
import com.qianfan.learncompose.theme.ComposeDemoTheme
import com.qianfan.learncompose.R
import com.qianfan.learncompose.theme.Divider


@Composable
fun MainPage(navController: NavController) {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(MaterialTheme.colors.primary)
    ) {
        val currentPosition = remember { mutableStateOf(0) }
        val onTabClick = fun(position: Int) {
            currentPosition.value = position
        }

        val chatViewModel:ChatViewModel = viewModel()
        chatViewModel.lazyListState = rememberLazyListState()

        val painter = rememberImagePainter(
            data = "https://img2.baidu.com/it/u=1429175118,2649084526&fm=26&fmt=auto",
            builder = {
                transformations(CircleCropTransformation())
                crossfade(300)
                placeholder(R.mipmap.icon_default_avatar)
            })

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.0f)
                .statusBarsPadding()
                .background(Color.White)
        ) {
            when (currentPosition.value) {
                0 -> HomePage(navController = navController,painter)
                1 -> ForumPage(navController = navController,painter)
                2 -> PaiPage(navController = navController,painter)
                3 -> ChatPage(navController = navController,chatViewModel,painter)
            }
        }
        Surface(
            color = Divider,
            modifier = Modifier
                .fillMaxWidth()
                .height(0.5.dp)
        ) {

        }
        BottomTab(currentPosition, onTabClick)
    }
}


@Preview
@Composable
fun previewMain() {
    val navController = rememberNavController()
    ProvideWindowInsets {
        ComposeDemoTheme {
            MainPage(navController)
        }
    }
}



