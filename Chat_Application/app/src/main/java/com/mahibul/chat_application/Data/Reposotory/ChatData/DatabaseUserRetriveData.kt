package com.mahibul.chat_application.Data.Reposotory.ChatData

data class DatabaseUserRetriveData (val id :String, val user_name :String, val image_url : String){
    constructor():this ("","","")
}