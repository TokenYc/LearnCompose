package com.qianfan.learncompose.compose.widget

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.qianfan.learncompose.R
import com.qianfan.learncompose.theme.DividerColor
import com.qianfan.learncompose.theme.TextGrey
import kotlinx.coroutines.launch
import java.util.*
import kotlin.concurrent.timerTask

@Composable
fun Divider(
    color: Color = DividerColor,
    modifier: Modifier = Modifier
        .height(0.5.dp)
        .fillMaxWidth()
) {
    Surface(
        color = color, modifier = modifier
    ) {

    }
}

@Composable
fun BannerInfo() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            text = "今年双十一到手的第一个大货，就是 realme 新发布的第一款智能穿戴产品 T1 手表。T1 共有三种配色，传统的橄榄绿和活力黑，以及颇有 realme 特色的黑薄荷（OPPO 商城独占）。我买到的是橄榄绿配色。",
            maxLines = 2,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(top = 7.dp, bottom = 7.dp), overflow = TextOverflow.Ellipsis,
            fontSize = 14.sp
        )
        InfoFlowImage(
            url = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpic.jj20.com%2Fup%2Fallimg%2F1112%2F12091Q03244%2F1Q209103244-9.jpg&refer=http%3A%2F%2Fpic.jj20.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1640227849&t=331ba827c9ef65c1952db67bcd969f77",
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            corner = 8.dp,
            aspectRatio = 2.0f
        )
        Box(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(top = 5.dp, bottom = 5.dp)
        ) {
            Text(text = "少数派", color = TextGrey, fontSize = 10.sp)
            Text(
                text = "3分钟前",
                color = TextGrey,
                fontSize = 11.sp,
                modifier = Modifier.align(
                    Alignment.CenterEnd
                )
            )
        }
    }
}

@Composable
fun OneImageInfo() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(top = 7.dp, bottom = 7.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1.0f)
        ) {
            Text(
                text = "游戏《原神》公布的新角色云堇和申鹤，你更喜欢哪个角色？",
                maxLines = 3,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.0f),
                fontSize = 14.sp
            )
            Row {
                Text(text = "知乎", fontSize = 10.sp, color = TextGrey)
                Spacer(modifier = Modifier.padding(start = 5.dp))
                Text(text = "1150阅读", fontSize = 10.sp, color = TextGrey)
            }
        }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1.39f)
                .padding(top = 2.dp, bottom = 2.dp)
        ) {
            InfoFlowImage(
                url = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2Fb%2F541bc9b748632.jpg%3Fdown&refer=http%3A%2F%2Fpic1.win4000.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1640243729&t=867b0a363d9818ad9124265666b8896b",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            )
        }
    }
}

@Composable
fun ThreeImageInfo() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            text = "「肘击事件」詹姆斯被禁赛 1 场，事后曾寻求主动道歉，斯图尔特被禁赛 2 场，如何评价这个处罚？",
            maxLines = 2,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(top = 7.dp, bottom = 7.dp), overflow = TextOverflow.Ellipsis,
            fontSize = 14.sp
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            InfoFlowImage(
                url = "https://pics4.baidu.com/feed/9825bc315c6034a8eed4b3977921b55c092376a9.jpeg?token=e3eecc06eecfa9dd54d90c52b004a041",
                modifier = Modifier
                    .weight(1.0f)
            )
            Spacer(modifier = Modifier.width(5.dp))
            InfoFlowImage(
                url = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201708%2F01%2F20170801135140_zkVH4.jpeg&refer=http%3A%2F%2Fb-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1640248226&t=24b92d891af4776f35192305cf93fe46",
                modifier = Modifier
                    .weight(1.0f)
            )
            Spacer(modifier = Modifier.width(5.dp))
            InfoFlowImage(
                url = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fwww.v3wall.com%2Fwallpaper%2F1680_1050%2F1205%2F1680_1050_201205210214272253131.jpg&refer=http%3A%2F%2Fwww.v3wall.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1640248654&t=421e6e0ad855a846fad9c05377ff17ee",
                modifier = Modifier
                    .weight(1.0f)
            )
        }
        Box(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(top = 5.dp, bottom = 5.dp)
        ) {
            Text(text = "虎扑", color = TextGrey, fontSize = 10.sp)
            Text(
                text = "10分钟前",
                color = TextGrey,
                fontSize = 11.sp,
                modifier = Modifier.align(
                    Alignment.CenterEnd
                )
            )
        }
    }
}

@Composable
fun InfoFlowImage(url: String, corner: Dp = 5.dp, aspectRatio: Float = 1.39f, modifier: Modifier) {
    Surface(
        shape = RoundedCornerShape(corner),
        modifier = if (aspectRatio > 0) modifier.aspectRatio(aspectRatio) else modifier
    ) {
        Image(
            painter = rememberImagePainter(data = url,
                builder = {
                    placeholder(R.color.img_default)
                }),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
    }
}

var timer: Timer? = null
var timerTask: TimerTask? = null

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalPagerApi::class)
@Composable
fun InfoFlowViewpager() {


    val pagerInfoList = mutableListOf(
        "https://i0.hdslb.com/bfs/sycp/creative_img/202111/34e34b3edf3a90061f5a8cd97a841f88.jpg@880w_388h_1c_95q",
        "https://i0.hdslb.com/bfs/feed-admin/b12a5c8e03b012f786e632129b9ab4706357d75e.jpg@880w_388h_1c_95q",
        "https://i0.hdslb.com/bfs/feed-admin/6a76533770fa825ad89d180cd099f07b585994d4.jpg@880w_388h_1c_95q",
    )
    val pageCount = pagerInfoList.size

    val startIndex = Int.MAX_VALUE / 2
    Log.d("page","init currentPage startIndex:${startIndex}")
    val pagerState = rememberPagerState(startIndex)
    val scope = rememberCoroutineScope()

    Log.d("page","init currentPage:${pagerState.currentPage}")

    timer?.cancel()
    timerTask?.cancel()
    timer = Timer()
    timerTask = object : TimerTask() {
        override fun run() {
            scope.launch {
                Log.d("page","currentPage:${pagerState.currentPage}")
                pagerState.animateScrollToPage(pagerState.currentPage + 1)
            }
        }
    }
    timer?.schedule(timerTask, 2000, 2000)


    HorizontalPager(
        count = Int.MAX_VALUE, modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.9f)
            .padding(top = 7.dp),
        state = pagerState
    ) { index ->

        val page = (index - startIndex).floorMod(pageCount)
        InfoFlowImage(
            url = pagerInfoList[page],
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            corner = 8.dp,
            aspectRatio = 0.0f
        )
    }
}

private fun Int.floorMod(other: Int): Int = when (other) {
    0 -> this
    else -> this - floorDiv(other) * other
}