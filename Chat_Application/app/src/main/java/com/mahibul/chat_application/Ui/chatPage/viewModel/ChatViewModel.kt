package com.mahibul.chat_application.Ui.chatPage.viewModel

import com.mahibul.chat_application.Data.Reposotory.ChatData.ChatModel
import com.mahibul.chat_application.Data.Reposotory.ChatData.ChatModelImp
import com.mahibul.chat_application.Data.Reposotory.ChatData.DatabaseUserRetriveData
import com.mahibul.chat_application.Ui.chatPage.view.ChatNotifyDataChange
import com.mahibul.chat_application.core.DataFatchCallback

class ChatViewModel(private val view : ChatNotifyDataChange) {

    private val model : ChatModel = ChatModelImp()

    fun getUserdata (){
        model.UserData(object : DataFatchCallback<DatabaseUserRetriveData>{
            override fun onSuccess(dataUser: DatabaseUserRetriveData) {
                view.userData(dataUser)
            }

            override fun onError(errorMsg: String) {
                view.errMsg(errorMsg)
            }

        })
    }
}