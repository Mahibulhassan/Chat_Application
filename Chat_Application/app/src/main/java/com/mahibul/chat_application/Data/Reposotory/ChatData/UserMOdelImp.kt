package com.mahibul.chat_application.Data.Reposotory.ChatData

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.mahibul.chat_application.core.DataFatchCallback

class UserMOdelImp : UserModel {

    override fun usersData(callback: DataFatchCallback<MutableList<DatabaseRetriveData>>) {
     //   val firebaseUser = FirebaseAuth.getInstance().currentUser
        val db = FirebaseDatabase.getInstance().getReference("user")
        db.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val users = mutableListOf<DatabaseRetriveData>()
                for (i in snapshot.children){
                    val user = i.getValue(DatabaseRetriveData::class.java)

                    /*if (user!!.id.equals(firebaseUser!!.uid!!)){
                        users.add(user!!)
                    }*/
                    users.add(user!!)
                }
                callback.onSuccess(users)
            }

            override fun onCancelled(error: DatabaseError) {
                callback.onError(error.message)
            }

        })
    }
}