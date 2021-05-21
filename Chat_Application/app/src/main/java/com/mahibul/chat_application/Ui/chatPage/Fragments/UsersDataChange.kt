package com.mahibul.chat_application.Ui.chatPage.Fragments

import com.mahibul.chat_application.Data.Reposotory.ChatData.DatabaseRetriveData

interface UsersDataChange {
    fun userData (databaseRetriveData: MutableList<DatabaseRetriveData>)
    fun errMsg (errorMsg : String)
}