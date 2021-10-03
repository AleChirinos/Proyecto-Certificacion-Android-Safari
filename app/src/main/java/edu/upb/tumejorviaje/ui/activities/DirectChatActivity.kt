package edu.upb.tumejorviaje.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.ui.fragments.ChatConversationFragment
import edu.upb.tumejorviaje.ui.fragments.ChatTextEnter

class DirectChatActivity : AppCompatActivity() {

    val chatConversationFragment=ChatConversationFragment()
    val chatTextEnterFragment=ChatTextEnter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_direct_chat)
        replaceFragment(R.id.containerChatDirectText,chatTextEnterFragment)
        replaceFragment(R.id.containerChatDirectShow,chatConversationFragment)
    }


}