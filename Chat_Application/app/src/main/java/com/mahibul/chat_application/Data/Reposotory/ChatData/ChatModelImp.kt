package com.mahibul.chat_application.Data.Reposotory.ChatData

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.mahibul.chat_application.core.DataFatchCallback


class ChatModelImp:ChatModel {
    override fun UserData(callback: DataFatchCallback<DatabaseRetriveData>) {
        val firebaseUser = FirebaseAuth.getInstance().currentUser
        val db = FirebaseDatabase.getInstance().getReference("user").child(firebaseUser?.uid!!)

        db.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val userData = snapshot.getValue(DatabaseRetriveData::class.java)
                callback.onSuccess(userData!!)
            }

            override fun onCancelled(error: DatabaseError) {
                callback.onError(error.message)
            }
        })

    }
}