package com.qianfan.learncompose.compose.home

import android.util.Log
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.qianfan.learncompose.compose.widget.*
import com.qianfan.learncompose.theme.TextGrey
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import java.util.*
import kotlin.concurrent.timerTask

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomePage(navController: NavController, painter: ImagePainter) {
    val startIndex = Int.MAX_VALUE / 2
//    val pagerState = rememberPagerState(startIndex)
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        TopBar(tabName = "首页", painter = painter)
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(start = 14.dp, end = 14.dp)
        ) {
            item {

                InfoFlowViewpager()
                Grid(
                    horizontalPadding = 14.dp,
                    verticalPadding = 10.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(top = 10.dp, bottom = 10.dp)
                )
                Divider()
            }
            item {
                BannerInfo()
                Divider()
            }
            for (i in 0..10) {
                item {
                    ThreeImageInfo()
                    Divider()
                }
            }
            item {
                OneImageInfo()
                Divider()
            }
        }
    }
}

