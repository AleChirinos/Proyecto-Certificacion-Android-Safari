package edu.upb.tumejorviaje.ui.mainmenu.tabs.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import edu.upb.tumejorviaje.databinding.FragmentProfileBinding
import edu.upb.tumejorviaje.ui.mainmenu.tabs.feed.FeedListAdapter

class ProfileFragment: Fragment(){

    private var feedListAdapter = FeedListAdapter()
    private val profileViewModel : ProfileViewModel by activityViewModels()
    private lateinit var binding : FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        binding.profileViewModel=profileViewModel
        binding.lifecycleOwner=this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

            binding.rvProfile.adapter=feedListAdapter
            binding.rvProfile.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            LinearSnapHelper().attachToRecyclerView(binding.rvProfile)

            profileViewModel.myPosts.observe(viewLifecycleOwner) {
                feedListAdapter.addAll(it)
            }

            binding.swiperefresh.setOnRefreshListener {
                profileViewModel.updatePostsProfile(profileViewModel.userToShow.value!!.username).invokeOnCompletion {
                    binding.swiperefresh.isRefreshing = false
                }
            }
            profileViewModel.updatePostsProfile(profileViewModel.userToShow.value!!.username)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        profileViewModel.userToShow.postValue(profileViewModel.user.value)
    }
}