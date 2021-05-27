package com.mahibul.chat_application.Ui.chatPage.viewModel

import com.mahibul.chat_application.Data.Reposotory.ChatData.DatabaseUserRetriveData
import com.mahibul.chat_application.Data.Reposotory.ChatData.UserMOdelImp
import com.mahibul.chat_application.Data.Reposotory.ChatData.UserModel
import com.mahibul.chat_application.Ui.chatPage.Fragments.UsersDataChange
import com.mahibul.chat_application.core.DataFatchCallback

class UserViewModel(val view : UsersDataChange) {
    private val model : UserModel = UserMOdelImp()

    fun getUsers(){
        model.usersData(object : DataFatchCallback<MutableList<DatabaseUserRetriveData>>{
            override fun onSuccess(data: MutableList<DatabaseUserRetriveData>) {
                view.userData(data)
            }

            override fun onError(errorMsg: String) {
                view.errMsg(errorMsg)
            }

        })
    }
}