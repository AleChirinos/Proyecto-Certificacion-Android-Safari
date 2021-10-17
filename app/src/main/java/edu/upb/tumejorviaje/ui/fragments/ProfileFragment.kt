package edu.upb.tumejorviaje.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.data.TempDataProfile
import edu.upb.tumejorviaje.databinding.FragmentProfileBinding
import edu.upb.tumejorviaje.databinding.FragmentSearchBinding
import edu.upb.tumejorviaje.ui.adapters.FeedListAdapter

class ProfileFragment: Fragment(){

    private val feedListAdapter = FeedListAdapter()
    private lateinit var binding : FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.rvProfile.adapter = feedListAdapter

        binding.rvProfile.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        feedListAdapter.addAll(TempDataProfile.feedList)
    }
}