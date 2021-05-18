package com.mahibul.chat_application.Data.Reposotory.RegisterAndLogin

import com.mahibul.chat_application.core.DataFatchCallback

interface RegisterModel {
    fun registerUser(registerData: RegisterData,callback : DataFatchCallback<Int>)
    fun loginUser (loginData: LoginData,callback: DataFatchCallback<Int>)
}