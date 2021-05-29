package com.mahibul.chat_application.Ui.chatPage.viewModel

import com.mahibul.chat_application.Data.Reposotory.ChatData.DatabaseUserRetriveData
import com.mahibul.chat_application.Data.Reposotory.ChatData.ProfileMOdelImp
import com.mahibul.chat_application.Data.Reposotory.ChatData.ProfileModel
import com.mahibul.chat_application.Ui.chatPage.Fragments.ProfileDataChange
import com.mahibul.chat_application.core.DataFatchCallback

class ProfileViewModel(private val view : ProfileDataChange) {
    val model : ProfileModel = ProfileMOdelImp()
    fun getUserInfo(){
        model.getUserDetails(object : DataFatchCallback<DatabaseUserRetriveData>{
            override fun onSuccess(data: DatabaseUserRetriveData) {
                view.userData(data)
            }

            override fun onError(errorMsg: String) {
                view.errMsg(errorMsg)
            }

        })
    }

}