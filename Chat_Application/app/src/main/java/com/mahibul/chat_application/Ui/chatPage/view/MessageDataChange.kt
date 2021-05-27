package com.mahibul.chat_application.Ui.chatPage.view

import com.mahibul.chat_application.Data.Reposotory.ChatData.DatabaseUserRetriveData
import com.mahibul.chat_application.Data.Reposotory.ChatData.RetriveMsgDataClass

interface MessageDataChange {

    fun userData (databaseUserRetriveData: DatabaseUserRetriveData)
    fun errMsg (errorMsg : String)
    fun reciveMsm (Sms : MutableList<RetriveMsgDataClass>)
}