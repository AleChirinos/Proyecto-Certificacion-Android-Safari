package edu.upb.tumejorviaje.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.data.ChatsTempDataSource
import edu.upb.tumejorviaje.ui.adapters.ChatListAdapter

class ChatFragment: Fragment(){
    lateinit var btNewChat : View
    private val chatListAdapter = ChatListAdapter()
    private val newChatFragment = NewChatFragment()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btNewChat = view.findViewById(R.id.newChatButtom)
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvChats)
        recyclerView.adapter = chatListAdapter

        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        chatListAdapter.addAll(ChatsTempDataSource.chatsList)

        btNewChat.setOnClickListener {
            newChatFragment.show(childFragmentManager,"NewChat")
        }
    }
}