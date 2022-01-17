package com.example.daadalotaibi_beltexam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.daadalotaibi_beltexam.Database.TV
import com.example.daadalotaibi_beltexam.RVAdapter.RVDdapter
import com.example.daadalotaibi_beltexam.ViewModel.ViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class DBFragment : Fragment() {

    private lateinit var mainRV: RecyclerView
    private lateinit var backButton: FloatingActionButton
    private lateinit var rvDdapter: RVDdapter


    private val dbViewModel by lazy { ViewModelProvider(this).get(ViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_d_b, container, false)

        mainRV = view.findViewById(R.id.rvDB)
        backButton = view.findViewById(R.id.backBtn)

        loadRV()

        dbViewModel.getDBList().observe(viewLifecycleOwner) { result ->
            rvDdapter.updateShows(result)
        }

        dbViewModel.getDBList()

        backButton.setOnClickListener {
            findNavController().navigate(R.id.action_APIFragment_to_homeFragment)
        }

        return view
    }

    private fun loadRV() {
        rvDdapter = RVDdapter(this)
        mainRV.adapter = rvDdapter
        mainRV.layoutManager = LinearLayoutManager(requireContext())
    }

    fun deleteFromDB(tv: TV) {
        dbViewModel.deleteFromDB(tv)
    }

}