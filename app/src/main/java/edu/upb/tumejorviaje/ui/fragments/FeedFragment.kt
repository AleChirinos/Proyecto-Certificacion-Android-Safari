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
import edu.upb.tumejorviaje.ui.adapters.FeedListAdapter

class FeedFragment: Fragment(){

    private val feedListAdapter = FeedListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvFeed)
        recyclerView.adapter = feedListAdapter
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        feedListAdapter.addAll(TempDataSource.feedList)

        feedListAdapter.setOnFeedItemClickListener {
            val arguments = Bundle().apply {
                putSerializable("post", it)
            }

            //val fragment = PostDetailsFragment().apply {
            //    this.arguments = arguments
            //}

            //val transaction = parentFragmentManager.beginTransaction()
            //transaction.add(R.id.container, PostDetailsFragment())
            //transaction.addToBackStack("Test")
            //transaction.commit()

            findNavController().navigate(R.id.action_feedFragment_to_postDetailsFragment, arguments)
            //val directions = FeedFragmentDirections.actionFeedFragmentToPostDetailsFragment(it)
            //findNavController().navigate(directions)
        }
    }

}

