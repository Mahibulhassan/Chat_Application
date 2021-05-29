package com.mahibul.chat_application.Ui.chatPage.Fragments

import com.mahibul.chat_application.Data.Reposotory.ChatData.DatabaseUserRetriveData

interface ProfileDataChange {
    fun userData (databaseUserRetriveData:DatabaseUserRetriveData)
    fun errMsg (errorMsg : String)
}