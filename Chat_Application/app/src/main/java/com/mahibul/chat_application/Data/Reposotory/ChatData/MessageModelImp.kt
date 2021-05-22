package com.mahibul.chat_application.Data.Reposotory.ChatData

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.mahibul.chat_application.core.DataFatchCallback

class MessageModelImp() : MessageModel {
    override fun getUserInfo(user_id: String, callback: DataFatchCallback<DatabaseRetriveData>) {

        val db = FirebaseDatabase.getInstance().getReference("user").child(user_id)
        db.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val user = snapshot.getValue(DatabaseRetriveData::class.java)
                callback.onSuccess(user!!)
            }

            override fun onCancelled(error: DatabaseError) {
                callback.onError(error.message)
            }

        })
    }

}