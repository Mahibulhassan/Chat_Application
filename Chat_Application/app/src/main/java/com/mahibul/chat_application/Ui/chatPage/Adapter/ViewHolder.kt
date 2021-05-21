package com.mahibul.chat_application.Ui.chatPage.Adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.user_item_layout.view.*

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val user_name = itemView.id_username
    val image_view = itemView.profile_image
}