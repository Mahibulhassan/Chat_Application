package com.mahibul.chat_application.Ui.chatPage.view

import com.mahibul.chat_application.Data.Reposotory.ChatData.DatabaseRetriveData

interface ChatNotifyDataChange {

    fun userData (databaseRetriveData: DatabaseRetriveData)
    fun errMsg (errorMsg : String)
}