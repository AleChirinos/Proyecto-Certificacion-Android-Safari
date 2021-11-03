package edu.upb.tumejorviaje.ui.directChat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.databinding.FragmentChatProgressBinding
import edu.upb.tumejorviaje.databinding.FragmentTextEnterBinding

class ChatTextEnter: Fragment(){
    private val chatBubbleViewModel: ChatBubbleViewModel by activityViewModels()
    private lateinit var binding: FragmentTextEnterBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentTextEnterBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.sendIcon.setOnClickListener {

            chatBubbleViewModel.saveNewBubble(binding.editTextTextMultiLine.text.toString())
        }
    }

}
