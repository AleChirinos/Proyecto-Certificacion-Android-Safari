package edu.upb.tumejorviaje.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.data.TempDataSource
import edu.upb.tumejorviaje.databinding.FragmentFeedBinding
import edu.upb.tumejorviaje.ui.adapters.FeedListAdapter

class FeedFragment: Fragment(){

    private val feedListAdapter = FeedListAdapter()
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
        feedListAdapter.addAll(TempDataSource.feedList)

        feedListAdapter.setOnFeedItemClickListener {
            val arguments = Bundle().apply {
                putSerializable("post", it)
            }

            findNavController().navigate(R.id.action_feedFragment_to_postDetailsFragment, arguments)

        }
    }

}

