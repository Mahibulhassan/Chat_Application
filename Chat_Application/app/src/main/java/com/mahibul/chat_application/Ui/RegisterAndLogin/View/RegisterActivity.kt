package com.mahibul.chat_application.Ui.RegisterAndLogin.View

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.widget.Toolbar
import com.mahibul.chat_application.Data.Reposotory.RegisterAndLogin.RegisterData
import com.mahibul.chat_application.R
import com.mahibul.chat_application.Ui.RegisterAndLogin.ViewModel.RegisterViewModel
import com.mahibul.chat_application.Ui.chatPage.view.ChatActivity
import com.mahibul.chat_application.core.BaseActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity(),RegisterActivityMove {

    private  val viewModel = RegisterViewModel(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        //     setSupportActionBar(toolbar as Toolbar?)
        (toolbar as Toolbar?)?.setTitle("Register")

        btn_register.setOnClickListener {
            val user_name = edt_username.text.toString()
            val email = edt_email.text.toString()
            val passwor = edt_password.text.toString()
            if (TextUtils.isEmpty(user_name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(
                    passwor
                )
            ) {
                showToast("All Fields are requred")
            } else if (passwor.length < 6) {
                showToast("Password Must be upto 6 char")
            } else {
                viewModel.registerUser(RegisterData(user_name, email, passwor))
            }
        }
    }

    override fun moveActivity(success: Int) {
        if (success == 5){
            val intent = Intent(this,ChatActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun errSms(errMsg: String) {
        showToast(errMsg)
    }
}