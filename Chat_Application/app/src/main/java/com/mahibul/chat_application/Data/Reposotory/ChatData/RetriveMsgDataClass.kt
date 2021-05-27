package com.mahibul.chat_application.Data.Reposotory.ChatData

data class RetriveMsgDataClass(val sender : String, val receiver : String,val message : String){
    constructor():this("","","")
}
