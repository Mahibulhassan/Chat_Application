package com.mahibul.chat_application.Ui.RegisterAndLogin.ViewModel

import com.mahibul.chat_application.Data.Reposotory.RegisterAndLogin.RegisterData
import com.mahibul.chat_application.Data.Reposotory.RegisterAndLogin.RegisterModel
import com.mahibul.chat_application.Data.Reposotory.RegisterAndLogin.RegisterModelImp
import com.mahibul.chat_application.Ui.RegisterAndLogin.View.RegisterActivityMove
import com.mahibul.chat_application.core.DataFatchCallback

class RegisterViewModel(private val view : RegisterActivityMove) {

    private val model : RegisterModel = RegisterModelImp()
    fun registerUser(registerData: RegisterData){
        model.registerUser(registerData,object : DataFatchCallback<Int>{
            override fun onSuccess(data: Int) {
                view.moveActivity(data)
            }

            override fun onError(errorMsg : String) {
                view.errSms(errorMsg)
            }
        })
    }
}