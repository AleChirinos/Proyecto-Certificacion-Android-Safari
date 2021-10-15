package edu.upb.tumejorviaje.ui.adapters

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
import edu.upb.tumejorviaje.model.ChatBubble

class ChatBubbleListAdapter: RecyclerView.Adapter<ChatBubbleViewHolder>(){
    private val elementList:MutableList<ChatBubble> = mutableListOf()


    fun addAll(newElementList:List<ChatBubble>){
        elementList.clear()
        elementList.addAll(newElementList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatBubbleViewHolder {
        val binding=ListItemBubbleBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ChatBubbleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChatBubbleViewHolder, position: Int) {
       holder.bind(elementList[position])
    }

    override fun getItemCount(): Int {
        return elementList.size
    }

}

class ChatBubbleViewHolder(val binding: ListItemBubbleBinding):RecyclerView.ViewHolder(binding.root) {

    fun bind(chatBubble: ChatBubble){
        binding.chatBubble=chatBubble
    }

}

