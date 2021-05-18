package com.mahibul.chat_application.Ui.RegisterAndLogin.ViewModel

import androidx.lifecycle.MutableLiveData
import com.mahibul.chat_application.Data.Reposotory.RegisterAndLogin.LoginData
import com.mahibul.chat_application.Data.Reposotory.RegisterAndLogin.RegisterModel
import com.mahibul.chat_application.Data.Reposotory.RegisterAndLogin.RegisterModelImp
import com.mahibul.chat_application.Ui.RegisterAndLogin.View.LoginActivityMove
import com.mahibul.chat_application.core.DataFatchCallback

class LoginViewModel(private val view : LoginActivityMove) {

    private val model : RegisterModel = RegisterModelImp()

    fun loginUser(loginData: LoginData){
        model.loginUser(loginData,object :DataFatchCallback<Int>{
            override fun onSuccess(data: Int) {
                view.moveActivity(data)
            }

            override fun onError(errorMsg : String) {
                view.errSms(errorMsg)
            }
        })
    }
}