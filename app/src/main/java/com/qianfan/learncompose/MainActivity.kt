package com.qianfan.learncompose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.qianfan.learncompose.theme.ComposeDemoTheme

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {
//                MsgCardCompose.MessageCard(MsgCardCompose.message)
                ConversationCompose.Conversation(
                    messageList = ConversationCompose.messageList
                )
            }
        }
    }


}