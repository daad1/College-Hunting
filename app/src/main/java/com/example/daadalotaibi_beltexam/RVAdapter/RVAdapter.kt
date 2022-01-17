package com.example.daadalotaibi_beltexam.RVAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.daadalotaibi_beltexam.APIFragment
import com.example.daadalotaibi_beltexam.Database.UniversityTable
import com.example.daadalotaibi_beltexam.Model.Universities
import com.example.daadalotaibi_beltexam.R
import kotlinx.android.synthetic.main.item_row.view.*

class RVAdapter (private val fragment: APIFragment, private var list: Universities)
    : RecyclerView.Adapter<RVAdapter.ItemViewHolder>() {


    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var data = list[position]

        holder.itemView.apply {
            btUniName.text = data.name
        }

        holder.itemView.btUniName.setOnClickListener {
            Toast.makeText(
                fragment.requireContext(),
                "${data.name} is added",
                Toast.LENGTH_LONG
            ).show()
            fragment.myViewModel.addUniversity(UniversityTable(0,data.name!!,data.country!!,""))
        }
    }
    override fun getItemCount() = list.size


}