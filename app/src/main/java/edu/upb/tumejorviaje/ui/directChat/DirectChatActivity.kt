package edu.upb.tumejorviaje.ui.directChat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.databinding.ActivityDirectChatBinding
import edu.upb.tumejorviaje.ui.replaceFragment

class DirectChatActivity : AppCompatActivity() {

    val chatConversationFragment= ChatConversationFragment()
    val chatTextEnterFragment= ChatTextEnter()
    lateinit var arguments : DirectChatActivityArgs
    private val chatBubbleViewModel: ChatBubbleViewModel by viewModels()
    private lateinit var binding : ActivityDirectChatBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        arguments = DirectChatActivityArgs.fromBundle(intent.extras!!)
        chatBubbleViewModel.savedChat.postValue(arguments.savedChat)

        binding = ActivityDirectChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(R.id.containerChatDirectText,chatTextEnterFragment)
        replaceFragment(R.id.containerChatDirectShow,chatConversationFragment)




        chatBubbleViewModel.savedChat.observe(this){
            binding.chatName.text = it.user.username
            Glide.with(this).load(it.user.profileUrl).into(binding.chatDirectIcon)
        }
    }




}