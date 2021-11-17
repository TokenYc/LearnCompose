package com.qianfan.learncompose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import androidx.core.view.WindowCompat
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.request.ImageResult
import java.time.Duration

class StartActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            page()
        }
    }

    @Composable
    fun page() {


        var showButton by remember { mutableStateOf(false) }


        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.0f)
            ) {
                Image(
                    painter = rememberImagePainter(
                        "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg3.doubanio.com%2Fview%2Fgroup_topic%2Fl%2Fpublic%2Fp155015141.jpg&refer=http%3A%2F%2Fimg3.doubanio.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1639724790&t=0ccb245151ddcd85da741414cb3f4358",
                        builder = {
                            crossfade(true)
                            listener(object : ImageRequest.Listener {
                                override fun onSuccess(
                                    request: ImageRequest,
                                    metadata: ImageResult.Metadata
                                ) {
                                    super.onSuccess(request, metadata)
                                    showButton = true
                                }
                            })
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
                            Toast.makeText(this@StartActivity, "跳转", Toast.LENGTH_LONG).show()
                        },
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(0.dp, 0.dp, 10.dp, 10.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0x80000000))
                    ) {
                        Text(text = "跳过", color = Color.White)
                    }
                }
            }

            Image(
                painter = painterResource(id = R.mipmap.splash_ad_bg),
                contentDescription = "splash_ad_bg",
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(0.dp, 0.dp, 0.dp, 15.dp)
            )
        }

    }

    @Preview
    @Composable
    fun previewPage() {
        page()
    }

}