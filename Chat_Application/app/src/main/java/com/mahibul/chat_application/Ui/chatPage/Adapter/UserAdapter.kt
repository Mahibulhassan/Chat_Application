package com.mahibul.chat_application.Ui.chatPage.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mahibul.chat_application.Data.Reposotory.ChatData.DatabaseUserRetriveData
import com.mahibul.chat_application.R

class UserAdapter(private val context: Context, private val users : MutableList<DatabaseUserRetriveData>,
                  private val clickListner : UserAdapter.userClickListner): RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =LayoutInflater.from(context).inflate(R.layout.user_item_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val user = users.get(position)
        holder.user_name.text = user.user_name
        if (user.image_url.equals("default")){
            holder.image_view.setImageResource(R.mipmap.ic_launcher)
        }else{
            Glide.with(context).load(user.image_url).into(holder.image_view)
        }

        holder.itemView.setOnClickListener {
            clickListner.onUserClick(user.id)
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }

    interface userClickListner {
        fun onUserClick (user_id : String)
    }
}