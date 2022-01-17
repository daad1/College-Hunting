package com.example.daadalotaibi_beltexam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.daadalotaibi_beltexam.Database.TV
import com.example.daadalotaibi_beltexam.RVAdapter.RVAdapter


class APIFragment : Fragment() {

    private lateinit var rvAdapter: RVAdapter
    private lateinit var mainRV: RecyclerView
    private lateinit var etShow: EditText
    private lateinit var searchButton: Button

   private val apiViewModel by lazy { ViewModelProvider(this).get(com.example.daadalotaibi_beltexam.ViewModel.ViewModel::class.java) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_a_p_i, container, false)

        mainRV = view.findViewById(R.id.rvMain)
        etShow = view.findViewById(R.id.etShowName)
        searchButton = view.findViewById(R.id.searchBtn)

        loadRV()

        apiViewModel.getList().observe(viewLifecycleOwner) { list ->
            rvAdapter.updateShows(list)
        }

        searchButton.setOnClickListener {
            if (etShow.text.isNotEmpty()) {
                apiViewModel.getData(etShow.text.toString())
                etShow.text.clear()
                etShow.clearFocus()
            } else
                Toast.makeText(requireContext(), "No Show name entered", Toast.LENGTH_SHORT)
                    .show()
        }

        return view
    }

    private fun loadRV() {
        rvAdapter = RVAdapter(this)
        mainRV.adapter = rvAdapter
        mainRV.layoutManager = LinearLayoutManager(requireContext())
    }

    fun addToDB(tvShow: TV) {
        apiViewModel.addToDB(tvShow)
    }

}