package com.mahibul.chat_application.Ui.chatPage.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.mahibul.chat_application.Data.Reposotory.ChatData.DatabaseRetriveData
import com.mahibul.chat_application.R
import com.mahibul.chat_application.Ui.Home.MainActivity
import com.mahibul.chat_application.Ui.chatPage.Fragments.ChatsFragment
import com.mahibul.chat_application.Ui.chatPage.Fragments.UsersFragment
import com.mahibul.chat_application.Ui.chatPage.viewModel.ChatViewModel
import com.mahibul.chat_application.core.BaseActivity
import kotlinx.android.synthetic.main.activity_chat.*
import kotlinx.android.synthetic.main.activity_login.*

class ChatActivity : BaseActivity(),ChatNotifyDataChange {

    private val viewModel = ChatViewModel(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        viewModel.getUserdata()

        logout_id.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
      //View Pager Adapter

        val viewpager = viewpager_id
        val viewPagerAdapter = viewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.addFragment(ChatsFragment(),"Chats")
        viewPagerAdapter.addFragment(UsersFragment(),"Users")

        viewpager.adapter = viewPagerAdapter
        tablelayout_id.setupWithViewPager(viewpager)
    }

    override fun userData(databaseRetriveData: DatabaseRetriveData) {
        user_id.text = databaseRetriveData.user_name
        if (databaseRetriveData.image_url == "default"){
            profile_image.setImageResource(R.mipmap.ic_launcher)
        }else{
            Glide.with(this@ChatActivity).load(databaseRetriveData.image_url).into(profile_image)
        }
        logout_id.visibility = View.VISIBLE
    }

    override fun errMsg(errorMsg: String) {
        showToast(errorMsg)
    }
    
}