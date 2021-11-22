package com.qianfan.learncompose.compose.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.qianfan.learncompose.R

@Composable
fun Grid(){
    val gridItems = mutableListOf<GridItem>()
    for (i in 0..11) {
        gridItems.add(
            GridItem(
                "https://c-ssl.duitang.com/uploads/item/202106/24/20210624211645_kdoqi.thumb.300_300_c.jpg_webp",
                "苹果"
            ),
        )
    }

    val rowSize = 5
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        items(
            items = gridItems.chunked(rowSize)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                it.forEachIndexed { index, item ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(1f / (rowSize - index))
                            .padding(7.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Surface(shape = RoundedCornerShape(5.dp)) {
                            Image(
                                painter = rememberImagePainter(item.icon,builder = {
                                    placeholder(R.color.img_default)
                                }),
                                contentDescription = "",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .aspectRatio(1.0f)
                            )
                        }
                        Text(text = item.text)
                    }
                }
            }
        }
    }
}
data class GridItem(val icon: String, val text: String)