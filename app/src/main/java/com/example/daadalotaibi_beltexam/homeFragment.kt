package com.example.daadalotaibi_beltexam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation


class homeFragment : Fragment() {

    lateinit var btBrowseApi: Button
    lateinit var btLocalDB: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)


        btBrowseApi = view.findViewById(R.id.btBrowseApi)
        btLocalDB = view.findViewById(R.id.btLocalDB)

        btBrowseApi.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_APIFragment)
        }
        btLocalDB.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_DBFragment)
        }

        return view
    }

}