package com.qianfan.learncompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import com.qianfan.learncompose.theme.ComposeDemoTheme

class MsgCardCompose {


    companion object {
        val message = Message("yang chen", "i am yc")

        @Composable
        fun MessageCard(message: Message) {
            Row(Modifier.padding(all = 8.dp)) {
                Image(
                    painter = painterResource(id = R.mipmap.avatar),
                    contentDescription = "contact pic",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .border(1.5.dp, Color("#2196F3".toColorInt()), CircleShape)
                )
                Spacer(modifier = Modifier.width(8.dp))

                var isExpanded by remember { mutableStateOf(false) }

                Surface(
                    elevation = 1.dp,
                    shape = RoundedCornerShape(5.dp),
                    color = MaterialTheme.colors.onSecondary
                ) {
                    Column(modifier = Modifier
                        .clickable { isExpanded = !isExpanded }
                        .padding(all = 4.dp)) {
                        Text(
                            text = "name:${message.name}",
                            color = MaterialTheme.colors.secondaryVariant
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "content:${message.content}",
                            style = MaterialTheme.typography.body2,
                            color = MaterialTheme.colors.secondaryVariant,
                            maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                        )
                    }
                }
            }
        }
    }


    @Preview(name = "Light Mode")
    @Composable
    fun PreviewMessageCard() {
        ComposeDemoTheme {
            MessageCard(message)
        }
    }

}