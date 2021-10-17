package edu.upb.tumejorviaje.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.databinding.ListItemChatsBinding
import edu.upb.tumejorviaje.databinding.ListItemNewChatBinding
import edu.upb.tumejorviaje.model.NewChat
import edu.upb.tumejorviaje.model.SavedChat

class NewChatListAdapter : RecyclerView.Adapter<NewChatListViewHolder>() {
    val elementList: MutableList<NewChat> = mutableListOf()

    fun addAll(newElementList: List<NewChat>) {
        elementList.clear()
        elementList.addAll(newElementList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewChatListViewHolder {
        val binding = ListItemNewChatBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return NewChatListViewHolder(binding)

    }

    override fun onBindViewHolder(holder: NewChatListViewHolder, position: Int) {
        holder.bind(elementList[position])
    }

    override fun getItemCount(): Int {
        return elementList.size
    }
}

class NewChatListViewHolder(val binding: ListItemNewChatBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(newChat: NewChat) {
        binding.newChat = newChat
    }


//class NewChatListViewHolder(val itemView: View): RecyclerView.ViewHolder(itemView) {
//    private val tvChatName = itemView.findViewById<TextView>(R.id.new_chat_name)
//
//
//    fun bind(newChat: NewChat) {
//        tvChatName.text = newChat.chatName
//    }
}