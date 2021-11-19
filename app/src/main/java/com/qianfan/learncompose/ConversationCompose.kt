package com.qianfan.learncompose

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.qianfan.learncompose.theme.ComposeDemoTheme


val messageList = mutableListOf(
    Message("yang chen", "i am yc"),
    Message("wang xiao qing", "i am wxq"),
    Message("wang shou xue", "i am wsx"),
    Message("wang jing", "i am wj"),
    Message("tang wei", "i am tw"),
    Message(
        "yang chen",
        "i am yc xxx xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"
    ),
    Message("wang xiao qing", "i am wxq"),
    Message("wang shou xue", "i am wsx"),
    Message("wang jing", "i am wj"),
    Message("tang wei", "i am tw"),
    Message("yang chen", "i am yc"),
    Message("wang xiao qing", "i am wxq"),
    Message("wang shou xue", "i am wsx"),
    Message("wang jing", "i am wj"),
    Message("tang wei", "i am tw"),
    Message("yang chen", "i am yc"),
    Message("wang xiao qing", "i am wxq"),
    Message("wang shou xue", "i am wsx"),
    Message("wang jing", "i am wj"),
    Message("tang wei", "i am tw"),
)

@Composable
fun Conversation(messageList: List<Message>, lazyListState: LazyListState) {
    LazyColumn(
        state = lazyListState,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        items(messageList) { message ->
            MsgCardCompose.MessageCard(
                message = message
            )
        }
    }
}

@Preview
@Composable
fun previewConversation() {
    val lazyListState = rememberLazyListState()
    ComposeDemoTheme {
        Conversation(
            messageList = messageList, lazyListState = lazyListState
        )
    }
}
