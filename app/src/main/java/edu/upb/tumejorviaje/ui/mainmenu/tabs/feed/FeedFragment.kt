package edu.upb.tumejorviaje.ui.mainmenu.tabs.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import edu.upb.tumejorviaje.databinding.FragmentFeedBinding
import edu.upb.tumejorviaje.ui.mainmenu.tabs.feed.FeedListAdapter

class FeedFragment: Fragment(){

    private val feedListAdapter = FeedListAdapter()
    private val feedViewModel : FeedViewModel by activityViewModels()
    private lateinit var binding : FragmentFeedBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFeedBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.rvFeed.adapter = feedListAdapter
        binding.rvFeed.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        LinearSnapHelper().attachToRecyclerView(binding.rvFeed)


        feedListAdapter.setOnFeedItemClickListener {
            val directions = FeedFragmentDirections.actionFeedFragmentToPostDetailsFragment(it)
            findNavController().navigate(directions)

        }

        feedViewModel.post.observe(viewLifecycleOwner){
            feedListAdapter.addAll(it)
        }
    }

}

