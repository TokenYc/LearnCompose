package com.qianfan.learncompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.samluys.statusbar.StatusBarUtils

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtils.transparencyBar(this)
        StatusBarUtils.StatusBarIconDark(this)
        setContentView(R.layout.activity_main)

//        setContent {
//            ComposeDemoTheme {
//                MsgCardCompose.MessageCard(MsgCardCompose.message)
//                ConversationCompose.Conversation(
//                    messageList = ConversationCompose.messageList
//                )
//            }


//        }
    }


}