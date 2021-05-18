package com.mahibul.chat_application.Ui.chatPage.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.mahibul.chat_application.R
import com.mahibul.chat_application.core.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*

class ChatActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        (toolbar as Toolbar?)?.setTitle("Chat Activity")
    }
}