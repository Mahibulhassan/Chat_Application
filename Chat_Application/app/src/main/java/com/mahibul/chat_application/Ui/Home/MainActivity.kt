package com.mahibul.chat_application.Ui.Home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.mahibul.chat_application.R
import com.mahibul.chat_application.Ui.RegisterAndLogin.View.LoginActivity
import com.mahibul.chat_application.Ui.RegisterAndLogin.View.RegisterActivity
import com.mahibul.chat_application.Ui.chatPage.view.ChatActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btn_login
import kotlinx.android.synthetic.main.activity_main.toolbar

class MainActivity : AppCompatActivity() {

    override fun onStart() {
        super.onStart()
        val firebaseUser = FirebaseAuth.getInstance().currentUser
        if (firebaseUser != null){
            startActivity(Intent(this,ChatActivity::class.java))
            finish()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (toolbar as Toolbar?)?.setTitle("Main Page")
        btn_register.setOnClickListener {
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }
        btn_login.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}