package com.mahibul.chat_application.Ui.chatPage.view

import com.mahibul.chat_application.Data.Reposotory.ChatData.DatabaseUserRetriveData

interface ChatNotifyDataChange {

    fun userData (databaseUserRetriveData: DatabaseUserRetriveData)
    fun errMsg (errorMsg : String)
}