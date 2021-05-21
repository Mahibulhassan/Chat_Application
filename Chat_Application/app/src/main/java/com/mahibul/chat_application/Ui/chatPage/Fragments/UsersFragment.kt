package com.mahibul.chat_application.Ui.chatPage.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mahibul.chat_application.Data.Reposotory.ChatData.DatabaseRetriveData
import com.mahibul.chat_application.R
import com.mahibul.chat_application.Ui.chatPage.Adapter.UserAdapter
import com.mahibul.chat_application.Ui.chatPage.viewModel.UserViewModel
import kotlinx.android.synthetic.main.fragment_users.*

class UsersFragment : Fragment(),UsersDataChange{


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_users, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = UserViewModel(this)
        viewModel.getUsers()

    }

    override fun userData(databaseRetriveData: MutableList<DatabaseRetriveData>) {
        val adapter = UserAdapter(requireContext(),databaseRetriveData)

        user_recyclerView_id.setHasFixedSize(true)
        user_recyclerView_id.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        user_recyclerView_id.adapter = adapter
    }

    override fun errMsg(errorMsg: String) {
        Toast.makeText(requireContext(),errorMsg,Toast.LENGTH_LONG).show()
    }

}