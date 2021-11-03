package edu.upb.tumejorviaje.ui.directChat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import edu.upb.tumejorviaje.data.ChatDirectTempDataSource
import edu.upb.tumejorviaje.data.UserTempDataSource
import edu.upb.tumejorviaje.databinding.FragmentChatProgressBinding
import edu.upb.tumejorviaje.ui.mainmenu.tabs.profile.ProfileViewModel
import kotlinx.coroutines.Job

class ChatConversationFragment: Fragment() {

    private lateinit var chatBubbleListAdapter: ChatBubbleListAdapter
    private lateinit var binding: FragmentChatProgressBinding
    private val profileViewModel: ProfileViewModel by activityViewModels()
    private val chatBubbleViewModel: ChatBubbleViewModel by activityViewModels()
    var chatBubbleJob: Job ?= null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentChatProgressBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        chatBubbleListAdapter = ChatBubbleListAdapter(UserTempDataSource.myUser, chatBubbleViewModel.savedChat.value!!.user)

        binding.rvChatBubbles.adapter=chatBubbleListAdapter
       val layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        binding.rvChatBubbles.layoutManager=layoutManager
        LinearSnapHelper().attachToRecyclerView(binding.rvChatBubbles)

        chatBubbleViewModel.chatBubbles.observe(viewLifecycleOwner){
            chatBubbleListAdapter.addAll(it)
        }

        chatBubbleJob= chatBubbleViewModel.updateChatBubbles(chatBubbleViewModel.savedChat.value!!.user)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        chatBubbleJob?.cancel()
    }

}