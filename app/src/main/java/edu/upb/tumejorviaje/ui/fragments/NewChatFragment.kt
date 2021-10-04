package edu.upb.tumejorviaje.ui.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.data.TempDataNewChats
import edu.upb.tumejorviaje.ui.activities.DirectChatActivity
import edu.upb.tumejorviaje.ui.adapters.NewChatListAdapter
import edu.upb.tumejorviaje.ui.base.StepsBaseFragment
import java.lang.ClassCastException

class NewChatFragment : DialogFragment(){
    private val newChatListAdapter = NewChatListAdapter()
    private lateinit var btnDirectChatActivity: View
    lateinit var recyclerView : View



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflater.inflate(R.layout.fragment_new_chat, container, false)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {


        return activity?.let {
            val builder = AlertDialog.Builder(it)
            // Get the layout inflater

            val inflater = requireActivity().layoutInflater;


            val v : View = inflater.inflate(R.layout.fragment_new_chat, null)
            btnDirectChatActivity=v.findViewById(R.id.start_new_chat_buttom)
            btnDirectChatActivity.setOnClickListener{

            }
            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            builder.setView(v)

            //Instantiate the recyclerView
            val recyclerView = v.findViewById<RecyclerView>(R.id.rvNewChat)

            recyclerView.adapter = newChatListAdapter

            recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

            newChatListAdapter.addAll(TempDataNewChats.chatsList)

            builder.create()


        } ?: throw IllegalStateException("Activity cannot be null")
    }


}
