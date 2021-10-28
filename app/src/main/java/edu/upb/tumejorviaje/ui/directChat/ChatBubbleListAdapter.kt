package edu.upb.tumejorviaje.ui.directChat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.databinding.ListItemBubbleBinding
import edu.upb.tumejorviaje.databinding.ListItemBubbleFromUserBinding
import edu.upb.tumejorviaje.model.ChatBubble
import edu.upb.tumejorviaje.model.User

class ChatBubbleListAdapter(val user: User): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val elementList:MutableList<ChatBubble> = mutableListOf()

    private val userViewType=1
    private val otherViewType=2

    fun addAll(newElementList:List<ChatBubble>){
        elementList.clear()
        elementList.addAll(newElementList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType==userViewType){
            val binding=ListItemBubbleFromUserBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return ChatBubbleFromUserViewHolder(binding)
        } else {
            val binding=ListItemBubbleBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return ChatBubbleViewHolder(binding)
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ChatBubbleViewHolder ->  holder.bind(elementList[position])
            is ChatBubbleFromUserViewHolder -> holder.bind(elementList[position])
        }
    }

    override fun getItemCount(): Int {
        return elementList.size
    }

    override fun getItemViewType(position: Int): Int {

        if(elementList[position].provenient.username==user.username){
            return userViewType
        } else {
            return otherViewType
        }
    }

}


class ChatBubbleFromUserViewHolder(val binding: ListItemBubbleFromUserBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(chatBubble: ChatBubble){
        binding.chatBubble=chatBubble
    }
}

class ChatBubbleViewHolder(val binding: ListItemBubbleBinding):RecyclerView.ViewHolder(binding.root) {

    fun bind(chatBubble: ChatBubble){
        binding.chatBubble=chatBubble
    }

}

