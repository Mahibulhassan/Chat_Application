package com.mahibul.chat_application.Ui.chatPage.Fragments

import android.app.ProgressDialog
import android.content.ContentResolver
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.MimeTypeMap
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.android.gms.tasks.Continuation
import com.google.android.gms.tasks.Task
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageTask
import com.google.firebase.storage.UploadTask
import com.mahibul.chat_application.Data.Reposotory.ChatData.DatabaseUserRetriveData
import com.mahibul.chat_application.R
import com.mahibul.chat_application.Ui.chatPage.viewModel.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_chats.*
import java.time.chrono.MinguoChronology
import kotlin.coroutines.CoroutineContext

class ProfileFragment : Fragment(),ProfileDataChange {

    val image_request =1


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chats, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ProfileViewModel(this)
        viewModel.getUserInfo()

        profile_image.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            startActivityForResult(intent,image_request)
        }
    }

    // uploading implement here




    override fun userData(databaseUserRetriveData: DatabaseUserRetriveData) {
        tv_profilename.text = databaseUserRetriveData.user_name
        if (databaseUserRetriveData.image_url.equals("default")){
            profile_image.setImageResource(R.mipmap.ic_launcher)
        }else{
            Glide.with(requireContext()).load(databaseUserRetriveData.image_url).into(profile_image)
        }
    }

    override fun errMsg(errorMsg: String) {
        Toast.makeText(requireContext(),errorMsg,Toast.LENGTH_SHORT).show()
    }
}