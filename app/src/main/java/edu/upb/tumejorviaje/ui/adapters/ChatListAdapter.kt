package edu.upb.tumejorviaje.ui.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.model.SavedChat


class ChatListAdapter() : RecyclerView.Adapter<ChatListViewHolder>() {

    private lateinit var mListener:onItemClickListener
    val elementList: MutableList<SavedChat> = mutableListOf()

    //interfaz necesaria del adaptador para acceder a las funciones de click en sus containers
    interface onItemClickListener{
        fun onItemClick()
    }

    //Estableciendo el listener(initerfaz)
    fun setOnItemClickListener(listener: onItemClickListener){
        mListener=listener
    }

    fun addAll(newElementList: MutableList<SavedChat>) {
        elementList.clear()
        elementList.addAll(newElementList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_chats, parent, false)
        return ChatListViewHolder(view,mListener)
    }

    override fun onBindViewHolder(holder: ChatListViewHolder, position: Int) {
        holder.bind(elementList[position])
    }

    override fun getItemCount(): Int {
        return elementList.size
    }


}

//Añadimos listener para que interactue con la interfaz
class ChatListViewHolder(val itemView: View,listener: ChatListAdapter.onItemClickListener): RecyclerView.ViewHolder(itemView) {

    private val ivChatImage = itemView.findViewById<ImageView>(R.id.chat_circle_profile)
    private val tvChatName = itemView.findViewById<TextView>(R.id.chat_name)
    private val tvChatLastMessage = itemView.findViewById<TextView>(R.id.chat_text)

    //Para darle a cada ViewHolder la funcion de clickListener
    init{
        itemView.setOnClickListener{
            listener.onItemClick()
        }
    }

    fun bind(savedChat: SavedChat) {
        ivChatImage.setImageResource(savedChat.profileImg)
        tvChatName.text = savedChat.chatName
        tvChatLastMessage.text = savedChat.chatLastMessage

    }


}