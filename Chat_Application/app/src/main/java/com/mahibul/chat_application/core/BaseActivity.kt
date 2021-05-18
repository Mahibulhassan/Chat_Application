package com.mahibul.chat_application.core

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity(){

    fun showToast(msg : String){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
    }
}