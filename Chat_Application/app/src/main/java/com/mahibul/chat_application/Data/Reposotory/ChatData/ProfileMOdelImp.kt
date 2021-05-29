package com.mahibul.chat_application.Data.Reposotory.ChatData

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.mahibul.chat_application.core.DataFatchCallback

class ProfileMOdelImp : ProfileModel {
    override fun getUserDetails(callback: DataFatchCallback<DatabaseUserRetriveData>) {
        val db = FirebaseDatabase.getInstance().getReference("user").child(FirebaseAuth.getInstance().currentUser?.uid!!)
        db.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val user = snapshot.getValue(DatabaseUserRetriveData::class.java)
                callback.onSuccess(user!!)
            }

            override fun onCancelled(error: DatabaseError) {
                callback.onError(error.message)
            }

        })
    }
}