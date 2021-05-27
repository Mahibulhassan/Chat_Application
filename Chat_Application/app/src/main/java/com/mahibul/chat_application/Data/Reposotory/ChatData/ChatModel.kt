package com.mahibul.chat_application.Data.Reposotory.ChatData

import com.mahibul.chat_application.core.DataFatchCallback

interface ChatModel {
    fun UserData (callback: DataFatchCallback<DatabaseUserRetriveData>)
}