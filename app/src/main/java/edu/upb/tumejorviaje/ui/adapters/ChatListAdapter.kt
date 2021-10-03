package edu.upb.tumejorviaje.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.model.SavedChat


class ChatListAdapter() : RecyclerView.Adapter<ChatListViewHolder>() {


    val elementList: MutableList<SavedChat> = mutableListOf()

    fun addAll(newElementList: MutableList<SavedChat>) {
        elementList.clear()
        elementList.addAll(newElementList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_chats, parent, false)
        return ChatListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatListViewHolder, position: Int) {
        holder.bind(elementList[position])

    }

    override fun getItemCount(): Int {
        return elementList.size
    }


}

class ChatListViewHolder(val itemView: View): RecyclerView.ViewHolder(itemView) {
    private val ivChatImage = itemView.findViewById<ImageView>(R.id.chat_circle_profile)
    private val tvChatName = itemView.findViewById<TextView>(R.id.chat_name)
    private val tvChatLastMessage = itemView.findViewById<TextView>(R.id.chat_text)



    fun bind(savedChat: SavedChat) {
        ivChatImage.setImageResource(savedChat.profileImg)
        tvChatName.text = savedChat.chatName
        tvChatLastMessage.text = savedChat.chatLastMessage

    }


}