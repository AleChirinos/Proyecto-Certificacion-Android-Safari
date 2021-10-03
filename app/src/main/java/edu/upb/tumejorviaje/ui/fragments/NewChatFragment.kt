package edu.upb.tumejorviaje.ui.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.data.TempDataNewChats
import edu.upb.tumejorviaje.ui.adapters.NewChatListAdapter

class NewChatFragment : DialogFragment(){
    private val newChatListAdapter = NewChatListAdapter()
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

            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            val v : View = inflater.inflate(R.layout.fragment_new_chat, null)
            builder.setView(v)

            val recyclerView = v.findViewById<RecyclerView>(R.id.rvNewChat)
            recyclerView.adapter = newChatListAdapter

            recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

            newChatListAdapter.addAll(TempDataNewChats.chatsList)

            builder.create()

        } ?: throw IllegalStateException("Activity cannot be null")
    }

}