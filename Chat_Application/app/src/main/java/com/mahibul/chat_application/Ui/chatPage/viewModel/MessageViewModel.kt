package com.mahibul.chat_application.Ui.chatPage.viewModel

import com.mahibul.chat_application.Data.Reposotory.ChatData.DatabaseUserRetriveData
import com.mahibul.chat_application.Data.Reposotory.ChatData.MessageModel
import com.mahibul.chat_application.Data.Reposotory.ChatData.MessageModelImp
import com.mahibul.chat_application.Data.Reposotory.ChatData.RetriveMsgDataClass
import com.mahibul.chat_application.Ui.chatPage.view.MessageDataChange
import com.mahibul.chat_application.core.DataFatchCallback

class MessageViewModel(private val view : MessageDataChange) {
    val model : MessageModel = MessageModelImp()

    fun getUserInfo(user_id : String){
        model.getUserInfo(user_id,object : DataFatchCallback<DatabaseUserRetriveData>{
            override fun onSuccess(dataUser: DatabaseUserRetriveData) {
                view.userData(dataUser)
            }

            override fun onError(errorMsg: String) {
                view.errMsg(errorMsg)
            }
        })
    }

    fun sendMsg(receber_id : String,msg : String){
        model.sendMsg(receber_id,msg)
    }

    fun getMsg (receber_id : String){
        model.getSms(receber_id,object : DataFatchCallback<MutableList<RetriveMsgDataClass>>{
            override fun onSuccess(data: MutableList<RetriveMsgDataClass>) {
                view.reciveMsm(data)
            }

            override fun onError(errorMsg: String) {
                view.errMsg(errorMsg)
            }
        })

    }
}