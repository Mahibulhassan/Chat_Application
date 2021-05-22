package com.mahibul.chat_application.Data.Reposotory.ChatData

import com.mahibul.chat_application.core.DataFatchCallback

interface MessageModel {
    fun getUserInfo(user_id : String,callback: DataFatchCallback<DatabaseRetriveData>)
}