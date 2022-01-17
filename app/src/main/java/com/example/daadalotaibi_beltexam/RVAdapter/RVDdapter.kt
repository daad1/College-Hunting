package com.example.daadalotaibi_beltexam.RVAdapter

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.daadalotaibi_beltexam.DBFragment
import com.example.daadalotaibi_beltexam.Database.UniversityTable
import com.example.daadalotaibi_beltexam.Model.MyViewModel
import com.example.daadalotaibi_beltexam.R
import kotlinx.android.synthetic.main.db_item_row.view.*
import kotlinx.android.synthetic.main.edit_dialog.*

class RVDdapter (private val fragment: DBFragment, private var list: ArrayList<UniversityTable>):  RecyclerView.Adapter<RVDdapter.ItemViewHolder>(){
    private val myViewModel by lazy { ViewModelProvider(fragment).get(MyViewModel::class.java) }

    class ItemViewHolder (itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.db_item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var data = list[position]


        holder.itemView.apply {
            tvName.text = data.name
            tvCountry.text = data.country

        }
        holder.itemView.btUpdate.setOnClickListener {
            updateDialog(position)
        }

        holder.itemView.btDelete.setOnClickListener {
            fragment.myViewModel.deleteUniversity(UniversityTable(data.id,data.name,data.country,data.note))
        }
        holder.itemView.setOnClickListener {
            Toast.makeText(
                fragment.requireContext(),
                "${data.note}",
                Toast.LENGTH_LONG
            ).show()
        }



    }

    fun updateDialog(position: Int){
        var myInfoDialog = Dialog(fragment.requireContext())
        myInfoDialog.setContentView(R.layout.edit_dialog)
        myInfoDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        myInfoDialog.show()

        myInfoDialog.etNoteUpdate.setText(list[position].note)


        myInfoDialog.btNoteUpdate.setOnClickListener {
            if (myInfoDialog.etNoteUpdate.text.isNotBlank()) {
                list[position].note = myInfoDialog.etNoteUpdate.text.toString()
                fragment.myViewModel.updateUniversity(list[position])
                Toast.makeText(
                    fragment.requireContext(),
                    "Update success!!",
                    Toast.LENGTH_SHORT
                ).show()
                myInfoDialog.dismiss()
            }
            else {
                Toast.makeText(
                    fragment.requireContext(),
                    "Do not leave it empty",
                    Toast.LENGTH_SHORT
                ).show()
                myInfoDialog.dismiss()
            }
        }
        myInfoDialog.btCansle.setOnClickListener{
            myInfoDialog.dismiss()
        }


    }

    override fun getItemCount() = list.size

    fun update(list: ArrayList<UniversityTable>){
        this.list = list
        notifyDataSetChanged()
    }
}