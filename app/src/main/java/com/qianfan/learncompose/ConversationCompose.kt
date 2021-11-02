package com.qianfan.learncompose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.qianfan.learncompose.theme.ComposeDemoTheme

class ConversationCompose {


    companion object {

        val messageList = mutableListOf(
            Message("yang chen", "i am yc"),
            Message("wang xiao qing", "i am wxq"),
            Message("wang shou xue", "i am wsx"),
            Message("wang jing", "i am wj"),
            Message("tang wei", "i am tw"),
            Message("yang chen", "i am yc xxx xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"),
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
        fun Conversation(messageList: List<Message>) {
            LazyColumn {
                items(messageList) { message ->
                    MsgCardCompose.MessageCard(
                        message = message
                    )
                }
            }
        }
    }

    @Preview
    @Composable
    fun previewConversation(){
        ComposeDemoTheme {
            Conversation(messageList = messageList)
        }
    }

}