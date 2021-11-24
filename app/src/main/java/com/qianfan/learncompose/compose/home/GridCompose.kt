package com.qianfan.learncompose.compose.home

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.qianfan.learncompose.R

@Composable
fun Grid(
    horizontalPadding: Dp = 0.dp,
    verticalPadding: Dp = 0.dp,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
) {
    val gridItems = mutableListOf<GridItem>()
    for (i in 0..7) {
        gridItems.add(
            GridItem(
                "https://c-ssl.duitang.com/uploads/item/202106/24/20210624211645_kdoqi.thumb.300_300_c.jpg_webp",
                "苹果"
            ),
        )
    }

    val rowSize = 5
    Column(
        modifier = modifier
    ) {
        val items = gridItems.chunked(rowSize)
        for (columnIndex in items.indices) {
            val columnItem = items[columnIndex]
            var topPadding = verticalPadding

            if (columnIndex == 0) {
                topPadding = 0.dp
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                for (index in 0 until rowSize) {
                    if (index < columnItem.size) {
                        val item = columnItem[index]
                        Column(
                            modifier = Modifier
                                .weight(1.0f)
                                .wrapContentHeight()
                                .padding(top = topPadding),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Surface(shape = RoundedCornerShape(5.dp)) {
                                Image(
                                    painter = rememberImagePainter(item.icon, builder = {
                                        placeholder(R.color.img_default)
                                    }),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .aspectRatio(1.0f)
                                )
                            }
                            Text(text = item.text, fontSize = 13.sp)
                        }
                    } else {
                        Box(
                            modifier = Modifier
                                .weight(1.0f)
                                .wrapContentHeight()
                        ) {

                        }
                    }
                    if (index < rowSize - 1) {
                        Spacer(modifier = Modifier.width(horizontalPadding))
                    }
                }
//                columnItem.forEachIndexed { index, item ->
//                    var leftPadding = padding
//                    var rightPadding = padding
//                    when (index) {
//                        0 -> {
//                            leftPadding = 0.dp
//                            rightPadding = padding * 2 / 3
//                        }
//                        rowSize - 1 -> {
//                            leftPadding = padding * 2 / 3
//                            rightPadding = 0.dp
//                        }
//                        else -> {
//                            leftPadding = padding * 1 / 3
//                            rightPadding = padding * 2 / 3
//                        }
//                    }
//                    Column(
//                        modifier = Modifier
//                            .fillMaxWidth(1f / (rowSize - index))
//                            .padding(start = leftPadding, end = rightPadding),
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//                        Surface(shape = RoundedCornerShape(5.dp)) {
//                            Image(
//                                painter = rememberImagePainter(item.icon, builder = {
//                                    placeholder(R.color.img_default)
//                                }),
//                                contentDescription = "",
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .aspectRatio(1.0f)
//                            )
//                        }
//                        Text(text = item.text)
//                    }
//                }
            }
        }
    }
}

data class GridItem(val icon: String, val text: String)