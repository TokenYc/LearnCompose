package com.qianfan.learncompose.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.request.ImageResult
import com.qianfan.learncompose.R


@Composable
fun StartPage(navController: NavController) {

    var showButton by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(5.5f)
        ) {
            Image(
                painter = rememberImagePainter(
                    "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg3.doubanio.com%2Fview%2Fgroup_topic%2Fl%2Fpublic%2Fp155015141.jpg&refer=http%3A%2F%2Fimg3.doubanio.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1639724790&t=0ccb245151ddcd85da741414cb3f4358",
                    builder = {
                        crossfade(300)
                        listener { _, _ ->
                            showButton = true
                        }
                    }
                ),
                contentDescription = "image start",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            )

            if (showButton) {
                Button(
                    onClick = {

                        navController.navigate("main")
                    },
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(0.dp, 0.dp, 10.dp, 10.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0x80000000))
                ) {
                    Text(text = "??????", color = Color.White)
                }
            }
        }


        Image(
            painter = painterResource(id = R.mipmap.splash_ad_bg),
            contentDescription = "splash_ad_bg",
            modifier = Modifier
                .weight(1.0f)
                .wrapContentWidth()
                .align(Alignment.CenterHorizontally)
                .padding(0.dp, 15.dp, 0.dp, 15.dp),
            contentScale = ContentScale.FillHeight
        )
    }

}


@Preview
@Composable
fun previewStart() {
    val navController = rememberNavController()

    StartPage(navController)
}
