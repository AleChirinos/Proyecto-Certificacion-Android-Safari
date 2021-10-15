package edu.upb.tumejorviaje.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.data.ChatDirectTempDataSource
import edu.upb.tumejorviaje.databinding.FragmentChatProgressBinding
import edu.upb.tumejorviaje.ui.adapters.ChatBubbleListAdapter
import edu.upb.tumejorviaje.ui.viewmodels.ChatBubbleViewModel

class ChatConversationFragment: Fragment() {

    private val chatBubbleListAdapter= ChatBubbleListAdapter()
    private lateinit var binding: FragmentChatProgressBinding
    private val chatBubbleViewModel:ChatBubbleViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentChatProgressBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.rvChatBubbles.adapter=chatBubbleListAdapter
       val layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        binding.rvChatBubbles.layoutManager=layoutManager
        LinearSnapHelper().attachToRecyclerView(binding.rvChatBubbles)

        chatBubbleViewModel.chatBubbles.observe(viewLifecycleOwner){
            chatBubbleListAdapter.addAll(it)
        }
    }

}