package com.mahibul.chat_application.Data.Reposotory.RegisterAndLogin


import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.mahibul.chat_application.core.DataFatchCallback

class RegisterModelImp : RegisterModel {

    val auth = FirebaseAuth.getInstance()

    override fun registerUser(registerData: RegisterData, callback: DataFatchCallback<Int>) {

         auth.createUserWithEmailAndPassword(registerData.email,registerData.password).addOnCompleteListener {
           if(it.isSuccessful){
               val user = auth.currentUser
               val user_id = user?.uid

               val db = FirebaseDatabase.getInstance().getReference("user").child("user_id")
               val userdef= user_id?.let { it1 -> DatabaseData(it1,registerData.user_name,"default") }
               db.setValue(userdef).addOnCompleteListener {
                   if (it.isSuccessful){
                       callback.onSuccess(5)
                   }else{
                       callback.onError("Authorigation Faield")
                   }
               }
           }else{
               callback.onError("Create Account Failed")
           }
         }
    }

    override fun loginUser(loginData: LoginData, callback: DataFatchCallback<Int>) {

        auth.signInWithEmailAndPassword(loginData.email,loginData.password).addOnCompleteListener {
            if (it.isSuccessful){
                callback.onSuccess(5)
            }else{
                callback.onError("Authinication Failed")
            }
        }
    }
}