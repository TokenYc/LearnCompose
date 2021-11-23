package com.qianfan.learncompose.compose.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.qianfan.learncompose.R

@Composable
fun BottomTab(currentPosition: MutableState<Int>, onClick: (Int) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.White)
    ) {

        val textSelectColor = MaterialTheme.colors.primary
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
                isSelect = index == currentPosition.value,
                imgSelect = tabData.imgSelect,
                imgUnSelect = tabData.imgUnSelect,
                label = tabData.label,
                textSelectColor = tabData.textSelectColor,
                textUnSelectColor = tabData.textUnSelectColor,
                modifier = Modifier.weight(1.0f),
                onClick = onClick
            )
        }
    }
}

@Composable
fun Tab(
    position: Int, isSelect: Boolean,
    imgSelect: Int, imgUnSelect: Int, label: String, textSelectColor: Color,
    textUnSelectColor: Color, modifier: Modifier, onClick: (Int) -> Unit
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
                onClick(position)
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var img by remember { mutableStateOf(imgUnSelect) }
        var textColor by remember { mutableStateOf(textUnSelectColor) }

        if (isSelect) {
            img = imgSelect
            textColor = textSelectColor
        } else {
            img = imgUnSelect
            textColor = textUnSelectColor
        }
        Image(
            painter = painterResource(id = img),
            contentDescription = "",
            colorFilter = ColorFilter.tint(textColor)
        )
        Text(text = label, color = textColor, fontSize = 11.sp)
    }
}

data class TabData(
    val imgSelect: Int,
    val imgUnSelect: Int,
    val textSelectColor: Color,
    val textUnSelectColor: Color,
    val label: String
)