package com.qianfan.learncompose.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.qianfan.learncompose.R

@Composable
fun BottomTab(currentPosition: MutableState<Int>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {

        val textSelectColor = Color(0xff2C97DE)
        val textUnSelectColor = Color(0x66000000)

        val tabs = mutableListOf(
            TabData(
                R.mipmap.ic_tab_1_press,
                R.mipmap.ic_tab_1_unpress,
                textSelectColor,
                textUnSelectColor,
                "首页"
            ),
            TabData(
                R.mipmap.ic_tab_2_press,
                R.mipmap.ic_tab_2_unpress,
                textSelectColor,
                textUnSelectColor,
                "社区"
            ),
            TabData(
                R.mipmap.ic_tab_3_press,
                R.mipmap.ic_tab_3_unpress,
                textSelectColor,
                textUnSelectColor,
                "巷友圈"
            ),
            TabData(
                R.mipmap.ic_tab_4_press,
                R.mipmap.ic_tab_4_unpress,
                textSelectColor,
                textUnSelectColor,
                "消息"
            )
        )

        tabs.forEachIndexed { index, tabData ->
            Tab(
                position = index,
                currentPosition = currentPosition,
                imgSelect = tabData.imgSelect,
                imgUnSelect = tabData.imgUnSelect,
                textSelectColor = tabData.textSelectColor,
                textUnSelectColor = tabData.textUnSelectColor,
                modifier = Modifier.weight(1.0f)
            )
        }
    }
}

@Composable
fun Tab(
    position: Int, currentPosition: MutableState<Int>,
    imgSelect: Int, imgUnSelect: Int, textSelectColor: Color,
    textUnSelectColor: Color, modifier: Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    Column(
        modifier = modifier
            .wrapContentHeight()
            .padding(0.dp, 5.dp, 0.dp, 5.dp)
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                currentPosition.value = position
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var img by remember { mutableStateOf(imgUnSelect) }
        var textColor by remember { mutableStateOf(textUnSelectColor) }

        if (position == currentPosition.value) {
            img = imgSelect
            textColor = textSelectColor
        } else {
            img = imgUnSelect
            textColor = textUnSelectColor
        }

        Image(painter = painterResource(id = img), contentDescription = "")
        Text(text = "首页", color = textColor, fontSize = 11.sp)
    }
}

data class TabData(
    val imgSelect: Int,
    val imgUnSelect: Int,
    val textSelectColor: Color,
    val textUnSelectColor: Color,
    val label: String
)