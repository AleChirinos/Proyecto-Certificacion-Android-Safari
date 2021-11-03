package edu.upb.tumejorviaje.ui.mainmenu.tabs.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import edu.upb.tumejorviaje.databinding.FragmentSearchBinding
import edu.upb.tumejorviaje.ui.mainmenu.tabs.feed.FeedListAdapter

class SearchFragment: Fragment(){
    private lateinit var binding : FragmentSearchBinding
    private val userFeedAdapter= UserSearchAdapter()
    private val searchViewModel: SearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        binding.searchViewModel=searchViewModel
        binding.lifecycleOwner=this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.rvSearchResults.adapter=userFeedAdapter
        binding.rvSearchResults.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        LinearSnapHelper().attachToRecyclerView(binding.rvSearchResults)

        searchViewModel.myUsers.observe(viewLifecycleOwner) {
            userFeedAdapter.addAll(it)
        }

        binding.editTextSearch.addTextChangedListener {
            searchViewModel.updateUsersSearch(binding.editTextSearch.text.toString())
        }



        searchViewModel.updateUsersSearch("")
    }


}