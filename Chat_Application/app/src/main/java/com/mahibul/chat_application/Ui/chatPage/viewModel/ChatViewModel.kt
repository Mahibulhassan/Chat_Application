package com.mahibul.chat_application.Ui.chatPage.viewModel

import com.mahibul.chat_application.Data.Reposotory.ChatData.ChatModel
import com.mahibul.chat_application.Data.Reposotory.ChatData.ChatModelImp
import com.mahibul.chat_application.Data.Reposotory.ChatData.DatabaseRetriveData
import com.mahibul.chat_application.Ui.chatPage.view.ChatNotifyDataChange
import com.mahibul.chat_application.core.DataFatchCallback

class ChatViewModel(private val view : ChatNotifyDataChange) {

    private val model : ChatModel = ChatModelImp()

    fun getUserdata (){
        model.UserData(object : DataFatchCallback<DatabaseRetriveData>{
            override fun onSuccess(data: DatabaseRetriveData) {
                view.userData(data)
            }

            override fun onError(errorMsg: String) {
                view.errMsg(errorMsg)
            }

        })
    }
}