package com.mahibul.chat_application.Data.Reposotory.ChatData

data class DatabaseRetriveData (val id :String,val user_name :String,val image_url : String){
    constructor():this ("","","")
}