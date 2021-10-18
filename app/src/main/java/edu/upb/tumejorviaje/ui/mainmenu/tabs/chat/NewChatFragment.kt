package edu.upb.tumejorviaje.ui.mainmenu.tabs.chat

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.data.TempDataNewChats
import edu.upb.tumejorviaje.databinding.FragmentNewChatBinding
import edu.upb.tumejorviaje.ui.mainmenu.tabs.chat.NewChatListAdapter

class NewChatFragment : DialogFragment(){
    private val newChatListAdapter = NewChatListAdapter()
    //private lateinit var btnDirectChatActivity: View
    //lateinit var recyclerView : View
    private lateinit var binding: FragmentNewChatBinding
    private val newChatsViewModel: NewChatsViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewChatBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {


        return activity?.let {
            val builder = AlertDialog.Builder(it)
            // Get the layout inflater

            val inflater = requireActivity().layoutInflater;


            val v : View = inflater.inflate(R.layout.fragment_new_chat, null)

            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            builder.setView(v)

            //Instantiate the recyclerView
            val recyclerView = v.findViewById<RecyclerView>(R.id.rvNewChat)

            recyclerView.adapter = newChatListAdapter

            recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

            newChatListAdapter.addAll(TempDataNewChats.getNewChatList())

            builder.create()


        } ?: throw IllegalStateException("Activity cannot be null")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.rvNewChat.adapter = newChatListAdapter
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvNewChat.layoutManager = layoutManager

        LinearSnapHelper().attachToRecyclerView(binding.rvNewChat)

        binding.startNewChatButtom.setOnClickListener{

        }


        newChatsViewModel.newChats.observe(viewLifecycleOwner){
            newChatListAdapter.addAll(it)
        }
    }
}
