package com.qianfan.learncompose.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.google.accompanist.insets.statusBarsPadding
import com.qianfan.learncompose.Conversation
import com.qianfan.learncompose.R
import com.qianfan.learncompose.messageList
import com.qianfan.learncompose.theme.ComposeDemoTheme

@Composable
fun ChatPage(navController: NavController, chatViewModel: ChatViewModel,painter:ImagePainter) {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        TopBar("聊天",painter)

        Conversation(
            messageList = messageList,
            lazyListState = chatViewModel.lazyListState
        )
    }
}

@Composable
@Preview
fun previewChatPage() {
    val navController = rememberNavController()
    val chatViewModel: ChatViewModel = viewModel()
    val painter = rememberImagePainter(
        data = "https://img2.baidu.com/it/u=1429175118,2649084526&fm=26&fmt=auto",
        builder = {
            transformations(CircleCropTransformation())
            crossfade(300)
            placeholder(R.mipmap.icon_default_avatar)
        })
    chatViewModel.lazyListState = rememberLazyListState()

    ComposeDemoTheme {
        ChatPage(navController = navController, chatViewModel,painter)
    }
}

class ChatViewModel : ViewModel() {
    lateinit var lazyListState: LazyListState

}