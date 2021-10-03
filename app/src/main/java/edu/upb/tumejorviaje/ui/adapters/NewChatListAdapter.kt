package edu.upb.tumejorviaje.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.model.NewChat

class NewChatListAdapter : RecyclerView.Adapter<NewChatListViewHolder>() {
    val elementList: MutableList<NewChat> = mutableListOf()

    fun addAll(newElementList: MutableList<NewChat>) {
        elementList.clear()
        elementList.addAll(newElementList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewChatListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_new_chat, parent, false)
        return NewChatListViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewChatListViewHolder, position: Int) {
        holder.bind(elementList[position])
    }

    override fun getItemCount(): Int {
        return elementList.size
    }
}

class NewChatListViewHolder(val itemView: View): RecyclerView.ViewHolder(itemView) {
    private val tvChatName = itemView.findViewById<TextView>(R.id.new_chat_name)


    fun bind(newChat: NewChat) {
        tvChatName.text = newChat.chatName
    }
}