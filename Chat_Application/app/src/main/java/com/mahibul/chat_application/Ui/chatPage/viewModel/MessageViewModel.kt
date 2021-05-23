package com.mahibul.chat_application.Ui.chatPage.viewModel

import com.mahibul.chat_application.Data.Reposotory.ChatData.DatabaseRetriveData
import com.mahibul.chat_application.Data.Reposotory.ChatData.MessageModel
import com.mahibul.chat_application.Data.Reposotory.ChatData.MessageModelImp
import com.mahibul.chat_application.Ui.chatPage.view.MessageDataChange
import com.mahibul.chat_application.core.DataFatchCallback

class MessageViewModel(private val view : MessageDataChange) {
    val model : MessageModel = MessageModelImp()

    fun getUserInfo(user_id : String){
        model.getUserInfo(user_id,object : DataFatchCallback<DatabaseRetriveData>{
            override fun onSuccess(data: DatabaseRetriveData) {
                view.userData(data)
            }

            override fun onError(errorMsg: String) {
                view.errMsg(errorMsg)
            }
        })
    }

    fun sendMsg(receber_id : String,msg : String){
        model.sendMsg(receber_id,msg)
    }
}