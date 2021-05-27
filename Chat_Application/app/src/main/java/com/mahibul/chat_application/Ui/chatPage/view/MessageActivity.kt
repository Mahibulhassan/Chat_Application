package com.mahibul.chat_application.Ui.chatPage.view

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.mahibul.chat_application.Data.Reposotory.ChatData.DatabaseUserRetriveData
import com.mahibul.chat_application.Data.Reposotory.ChatData.RetriveMsgDataClass
import com.mahibul.chat_application.R
import com.mahibul.chat_application.Ui.chatPage.Adapter.MassegeAdapter
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
        val reciver_id = intent.getStringExtra("user_id")
        viewMOdel.getUserInfo(reciver_id!!)

        //Sending msg to target user
        btn_send.setOnClickListener {
            val msg = text_sendid.text.toString()
            if (msg.equals("")) {
                showToast("Blank sms cann't be change")
            } else {
                viewMOdel.sendMsg(reciver_id!!, msg)
            }
            text_sendid.setText("")
        }

        //Reciving msg from firebase
        viewMOdel.getMsg(reciver_id!!)

    }

    override fun userData(databaseUserRetriveData: DatabaseUserRetriveData) {
        user_id.text = databaseUserRetriveData.user_name
        if (databaseUserRetriveData.image_url == "default"){
            profile_image.setImageResource(R.mipmap.ic_launcher)
        }else{
            Glide.with(this).load(databaseUserRetriveData.image_url).into(profile_image)
        }
    }

    override fun errMsg(errorMsg: String) {
        showToast(errorMsg)
    }

    override fun reciveMsm(Sms: MutableList<RetriveMsgDataClass>) {
        val adapter = MassegeAdapter(this,Sms)
        msg_recyclerview_id.setHasFixedSize(true)
        msg_recyclerview_id.layoutManager=
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL,false)
        msg_recyclerview_id.adapter = adapter
    }
}