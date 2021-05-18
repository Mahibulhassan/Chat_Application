package com.mahibul.chat_application.core

interface DataFatchCallback<T> {
    fun onSuccess(data : T)
    fun onError (errorMsg : String)
}