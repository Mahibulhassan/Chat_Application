package com.mahibul.chat_application.Ui.RegisterAndLogin.View

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.widget.Toolbar
import com.mahibul.chat_application.Data.Reposotory.RegisterAndLogin.LoginData
import com.mahibul.chat_application.R
import com.mahibul.chat_application.Ui.RegisterAndLogin.ViewModel.LoginViewModel
import com.mahibul.chat_application.Ui.chatPage.view.ChatActivity
import com.mahibul.chat_application.core.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.edt_email
import kotlinx.android.synthetic.main.activity_login.toolbar

class LoginActivity : BaseActivity(),LoginActivityMove {
    private var viewModel = LoginViewModel(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        (toolbar as Toolbar?)?.setTitle("Log in")

        btn_login.setOnClickListener {
            val email = edt_email.text.toString()
            val pass = edt_password.text.toString()
            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(pass)) {
                showToast("All Fields are requred")
            } else if (pass.length < 6) {
                showToast("Password Must be upto 6 char")
            } else {
                viewModel.loginUser(LoginData(email, pass))
            }
        }
    }

    override fun moveActivity(success: Int) {
        if (success == 5) {
            val intent = Intent(this, ChatActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun errSms(errMsg: String) {
        showToast(errMsg)
    }
}