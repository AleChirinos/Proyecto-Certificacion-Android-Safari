package edu.upb.tumejorviaje.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.data.ChatsTempDataSource
import edu.upb.tumejorviaje.databinding.FragmentChatBinding
import edu.upb.tumejorviaje.ui.adapters.ChatListAdapter
import edu.upb.tumejorviaje.ui.base.StepsBaseFragment
import edu.upb.tumejorviaje.ui.viewmodels.ChatsViewModel


class ChatFragment: StepsBaseFragment(){
    lateinit var btNewChat : View
    private val chatListAdapter = ChatListAdapter()
    private val newChatFragment = NewChatFragment()
    private val chatsViewModel: ChatsViewModel by activityViewModels()
    private lateinit var binding: FragmentChatBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.rvChats.adapter = chatListAdapter
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvChats.layoutManager = layoutManager

        LinearSnapHelper().attachToRecyclerView(binding.rvChats)

        chatListAdapter.setOnItemClickListener {
            val directions = ChatFragmentDirections.actionChatFragmentToDirectChatActivity()
            findNavController().navigate(directions)

        }

        binding.newChatButtom.setOnClickListener {
            newChatFragment.show(childFragmentManager,"NewChat")
        }

        chatsViewModel.chats.observe(viewLifecycleOwner) {
            chatListAdapter.addAll(it)
        }

//      Código reemplazado por view binding


//        btNewChat = view.findViewById(R.id.newChatButtom)
//
//        val recyclerView = view.findViewById<RecyclerView>(R.id.rvChats)
//        recyclerView.adapter = chatListAdapter
//        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
//        chatListAdapter.addAll(ChatsTempDataSource.chatsList)
//
//        //Para establecer la funcion de click de la interfaz en los recyclerView
//        chatListAdapter.setOnItemClickListener {
//            findNavController().navigate(R.id.action_chatFragment_to_directChatActivity, arguments)
//        }
//
//        //Para invocar al DialogFragment de ChatFragment
//        btNewChat.setOnClickListener {
//            newChatFragment.show(childFragmentManager,"NewChat")
//        }
    }




}