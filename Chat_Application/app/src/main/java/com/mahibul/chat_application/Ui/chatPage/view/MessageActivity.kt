package com.mahibul.chat_application.Ui.chatPage.view

import android.os.Bundle
import com.bumptech.glide.Glide
import com.mahibul.chat_application.Data.Reposotory.ChatData.DatabaseRetriveData
import com.mahibul.chat_application.R
import com.mahibul.chat_application.Ui.chatPage.viewModel.MessageViewModel
import com.mahibul.chat_application.core.BaseActivity
import kotlinx.android.synthetic.main.activity_message.*

class MessageActivity : BaseActivity(),MessageDataChange {

    private val viewMOdel = MessageViewModel(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)
        //Tollbar implement here
        val toolbar = toolbar
        toolbar.setTitle("")
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            finish()
        }
        //here call viewmodel and waiting for data
        val user_id = intent.getStringExtra("user_id")
        viewMOdel.getUserInfo(user_id!!)

    }

    override fun userData(databaseRetriveData: DatabaseRetriveData) {
        user_id.text = databaseRetriveData.user_name
        if (databaseRetriveData.image_url == "default"){
            profile_image.setImageResource(R.mipmap.ic_launcher)
        }else{
            Glide.with(this).load(databaseRetriveData.image_url).into(profile_image)
        }
    }

    override fun errMsg(errorMsg: String) {
        showToast(errorMsg)
    }
}