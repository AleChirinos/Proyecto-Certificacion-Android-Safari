package edu.upb.tumejorviaje.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.data.ChatDirectTempDataSource
import edu.upb.tumejorviaje.ui.adapters.ChatBubbleListAdapter

class ChatConversationFragment: Fragment() {

    private val chatBubbleListAdapter= ChatBubbleListAdapter()
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chat_progress,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerView=view.findViewById<RecyclerView>(R.id.rvChatBubbles)
        recyclerView.adapter=chatBubbleListAdapter
        recyclerView.layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        chatBubbleListAdapter.addAll(ChatDirectTempDataSource.chatBubbleList)
    }

}