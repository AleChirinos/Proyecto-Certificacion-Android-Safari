package edu.upb.tumejorviaje.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.data.ChatsTempDataSource
import edu.upb.tumejorviaje.ui.adapters.ChatListAdapter
import edu.upb.tumejorviaje.ui.base.StepsBaseFragment


class ChatFragment: StepsBaseFragment(){
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

        //Para establecer la funcion de click de la interfaz en los recyclerView
        chatListAdapter.setOnItemClickListener(object : ChatListAdapter.onItemClickListener{
            override fun onItemClick() {
                onSuccess?.invoke()
            }
        })

        //Para invocar al DialogFragment de ChatFragment
        btNewChat.setOnClickListener {
            newChatFragment.show(childFragmentManager,"NewChat")
        }
    }




}