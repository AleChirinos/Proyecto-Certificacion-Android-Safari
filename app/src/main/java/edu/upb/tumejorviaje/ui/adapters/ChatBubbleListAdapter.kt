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
import edu.upb.tumejorviaje.model.ChatBubble

class ChatBubbleListAdapter: RecyclerView.Adapter<ChatBubbleViewHolder>(){
    val elementList:MutableList<ChatBubble> = mutableListOf()

    fun addAll(newElementList:MutableList<ChatBubble>){
        elementList.clear()
        elementList.addAll(newElementList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatBubbleViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.list_item_bubble,parent,false)
        return ChatBubbleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatBubbleViewHolder, position: Int) {
       holder.bind(elementList[position])
    }

    override fun getItemCount(): Int {
        return elementList.size
    }

}

class ChatBubbleViewHolder(val itemView: View):RecyclerView.ViewHolder(itemView) {
    private val tvPostProfileImage=itemView.findViewById<ImageView>(R.id.userImage)
    private val tvPostChatText=itemView.findViewById<TextView>(R.id.chatCommentText)
    private val tvPostChatTime=itemView.findViewById<TextView>(R.id.chatCommentTime)

    fun bind(chatBubble:ChatBubble){
        Glide.with(itemView).load(chatBubble.profileImageUrl).transform(CenterCrop(), RoundedCorners(24)).into(tvPostProfileImage)
        tvPostChatText.text=chatBubble.textComment
        tvPostChatTime.text=chatBubble.time
    }

}

