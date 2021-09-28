package edu.upb.tumejorviaje.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import edu.upb.tumejorviaje.R

class MenuButtonFragmentU : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_button_options_u, container, false)
    }
}