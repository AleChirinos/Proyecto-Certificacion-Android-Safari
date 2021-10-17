package edu.upb.tumejorviaje.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.databinding.FragmentFeedBinding
import edu.upb.tumejorviaje.databinding.FragmentSearchBinding

class SearchFragment: Fragment(){
    private lateinit var binding : FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }
}