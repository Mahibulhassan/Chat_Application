package com.mahibul.chat_application.Ui.chatPage.Adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.chat_item_left.view.*

class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val msg  = itemView.show_massege
    val image_view = itemView.profile_image
}