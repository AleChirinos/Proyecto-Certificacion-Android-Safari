package edu.upb.tumejorviaje.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.databinding.ActivityDirectChatBinding
import edu.upb.tumejorviaje.ui.fragments.ChatConversationFragment
import edu.upb.tumejorviaje.ui.fragments.ChatTextEnter
import edu.upb.tumejorviaje.ui.viewmodels.ChatBubbleViewModel

class DirectChatActivity : AppCompatActivity() {

    val chatConversationFragment=ChatConversationFragment()
    val chatTextEnterFragment=ChatTextEnter()
    lateinit var arguments : DirectChatActivityArgs
    private val chatBubbleViewModel: ChatBubbleViewModel by viewModels()
    private lateinit var binding : ActivityDirectChatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDirectChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(R.id.containerChatDirectText,chatTextEnterFragment)
        replaceFragment(R.id.containerChatDirectShow,chatConversationFragment)

        arguments = DirectChatActivityArgs.fromBundle(intent.extras!!)

        chatBubbleViewModel.savedChat.postValue(arguments.savedChat)

        chatBubbleViewModel.savedChat.observe(this){
            binding.chatName.text = it.chatName
           binding.chatDirectIcon.setImageResource(it.profileImg)
        }
    }




}