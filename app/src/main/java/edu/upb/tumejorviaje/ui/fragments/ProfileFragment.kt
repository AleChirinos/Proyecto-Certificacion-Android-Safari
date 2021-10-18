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
import edu.upb.tumejorviaje.data.TempDataProfile
import edu.upb.tumejorviaje.databinding.FragmentProfileBinding
import edu.upb.tumejorviaje.databinding.FragmentSearchBinding
import edu.upb.tumejorviaje.ui.adapters.FeedListAdapter
import edu.upb.tumejorviaje.ui.viewmodels.ProfileViewModel

class ProfileFragment: Fragment(){

    private val feedListAdapter = FeedListAdapter()
    private val profileViewModel : ProfileViewModel by activityViewModels()
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

        LinearSnapHelper().attachToRecyclerView(binding.rvProfile)

//        feedListAdapter.addAll(TempDataProfile.getNewFeedList())

        profileViewModel.myPosts.observe(viewLifecycleOwner) {
            feedListAdapter.addAll(it)
        }
    }
}