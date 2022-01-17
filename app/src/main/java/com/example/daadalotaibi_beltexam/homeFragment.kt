package com.example.daadalotaibi_beltexam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation


class homeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        view.findViewById<Button>(R.id.apiBtn).setOnClickListener {
//            findNavController().navigate(R.id.action_mainFragment_to_apiFragment)
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_APIFragment)
        }

        view.findViewById<Button>(R.id.dbBtn).setOnClickListener {
//            findNavController().navigate(R.id.action_mainFragment_to_DBFragment)
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_DBFragment)
        }

        return view
    }

}