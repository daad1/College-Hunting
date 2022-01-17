package com.example.daadalotaibi_beltexam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.daadalotaibi_beltexam.Database.UnivercityTable
import com.example.daadalotaibi_beltexam.Model.MyViewModel
import com.example.daadalotaibi_beltexam.RVAdapter.RVDdapter



class DBFragment : Fragment() {

    lateinit var btDatabaseBack: Button
    lateinit var rvDatabase: RecyclerView
    lateinit var DatabaseAdapter: RVDdapter
    val myViewModel by lazy { ViewModelProvider(this).get(MyViewModel::class.java) }
    var list = ArrayList<UnivercityTable>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_d_b, container, false)

        rvDatabase =view.findViewById(R.id.rvDb)
        btDatabaseBack=view.findViewById(R.id.btDatabaseBack)

        btDatabaseBack.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_DBFragment_to_homeFragment)
        }

        myViewModel.getunivercity().observe(viewLifecycleOwner, {
                List ->
            DatabaseAdapter.update(List as ArrayList<UnivercityTable>)
        })

        DatabaseAdapter =RVDdapter(this ,list)
        this.rvDatabase.adapter = DatabaseAdapter
        this.rvDatabase.layoutManager = LinearLayoutManager(this.context)

        return view
    }

}