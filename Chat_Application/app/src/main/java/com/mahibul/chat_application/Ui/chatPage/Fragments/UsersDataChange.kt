package com.mahibul.chat_application.Ui.chatPage.Fragments

import com.mahibul.chat_application.Data.Reposotory.ChatData.DatabaseUserRetriveData

interface UsersDataChange {
    fun userData (databaseUserRetriveData: MutableList<DatabaseUserRetriveData>)
    fun errMsg (errorMsg : String)
}