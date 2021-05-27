package com.mahibul.chat_application.Ui.chatPage.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.mahibul.chat_application.Data.Reposotory.ChatData.RetriveMsgDataClass
import com.mahibul.chat_application.R

class MassegeAdapter(private val context: Context, private val msgs : MutableList<RetriveMsgDataClass>):RecyclerView.Adapter<MessageViewHolder> (){
    val  MSG_TYPE_LEFT =0
    val  MSG_TYPE_RIGHT =1
    val image_url ="default"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        if (viewType == MSG_TYPE_RIGHT){
            val view = LayoutInflater.from(context).inflate(R.layout.chat_item_right,parent,false)
            return MessageViewHolder(view)
        }else{
            val view = LayoutInflater.from(context).inflate(R.layout.chat_item_left,parent,false)
            return MessageViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val sms = msgs.get(position)
        holder.msg.setText(sms.message)
        if (image_url.equals("default")){
            holder.image_view.setImageResource(R.mipmap.ic_launcher)
        }else{
            Glide.with(context).load(image_url).into(holder.image_view)
        }
    }

    override fun getItemCount(): Int {
        return msgs.size
    }

    override fun getItemViewType(position: Int): Int {
        val fuser = FirebaseAuth.getInstance().currentUser
        if (msgs.get(position).sender.equals(fuser!!.uid)){
            return MSG_TYPE_RIGHT
        }else{
            return MSG_TYPE_LEFT
        }
    }

}