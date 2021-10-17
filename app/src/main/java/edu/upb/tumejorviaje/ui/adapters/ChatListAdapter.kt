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
import edu.upb.tumejorviaje.databinding.ListItemChatsBinding
import edu.upb.tumejorviaje.model.Post
import edu.upb.tumejorviaje.model.SavedChat


class ChatListAdapter() : RecyclerView.Adapter<ChatListViewHolder>() {

    private val elementList: MutableList<SavedChat> = mutableListOf()
    private var onPrivateItemClickListener: ((savedChat: SavedChat) -> Unit)? = null

    fun addAll(newElementList: List<SavedChat>) {
        elementList.clear()
        elementList.addAll(newElementList)
        notifyDataSetChanged()
    }

    //Estableciendo el listener(initerfaz)
    fun setOnItemClickListener(onPrivateItemClickListener: ((savedChat: SavedChat) -> Unit)?){
        this.onPrivateItemClickListener=onPrivateItemClickListener
    }

    //interfaz necesaria del adaptador para acceder a las funciones de click en sus containers
    //interface onItemClickListener{
    //    fun onItemClick()
    //}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatListViewHolder {
        val binding = ListItemChatsBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ChatListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChatListViewHolder, position: Int) {
        holder.bind(elementList[position])
        holder.itemView.setOnClickListener {
            onPrivateItemClickListener?.invoke(elementList[position])
        }

    }

    override fun getItemCount(): Int {
        return elementList.size
    }


}

//Añadimos listener para que interactue con la interfaz
class ChatListViewHolder(val binding: ListItemChatsBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(chat: SavedChat) {
        binding.chat = chat
    }

/*  Codigo reemplazado por ViewBinding

    private val ivChatImage = itemView.findViewById<ImageView>(R.id.chat_circle_profile)
    private val tvChatName = itemView.findViewById<TextView>(R.id.chat_name)
    private val tvChatLastMessage = itemView.findViewById<TextView>(R.id.chat_text)

    //Para darle a cada ViewHolder la funcion de clickListener
    //init{
    //    itemView.setOnClickListener{
    //        listener.onItemClick()
    //}
    //}

    fun bind(savedChat: SavedChat) {
        ivChatImage.setImageResource(savedChat.profileImg)
        tvChatName.text = savedChat.chatName
        tvChatLastMessage.text = savedChat.chatLastMessage

    }*/


}