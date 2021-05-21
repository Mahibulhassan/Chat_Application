package com.mahibul.chat_application.Data.Reposotory.ChatData

import com.mahibul.chat_application.core.DataFatchCallback

interface UserModel {
    fun usersData (callback: DataFatchCallback<MutableList<DatabaseRetriveData>>)
}