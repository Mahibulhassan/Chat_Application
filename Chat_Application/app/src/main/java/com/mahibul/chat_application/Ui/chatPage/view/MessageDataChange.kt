package com.mahibul.chat_application.Ui.chatPage.view

import com.mahibul.chat_application.Data.Reposotory.ChatData.DatabaseRetriveData

interface MessageDataChange {

    fun userData (databaseRetriveData: DatabaseRetriveData)
    fun errMsg (errorMsg : String)
}