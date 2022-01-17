package com.example.daadalotaibi_beltexam.RVAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.daadalotaibi_beltexam.DBFragment
import com.example.daadalotaibi_beltexam.Database.TV
import com.example.daadalotaibi_beltexam.R
import com.example.daadalotaibi_beltexam.databinding.DbItemRowBinding

class RVDdapter (val dbActivity: DBFragment) : RecyclerView.Adapter<RVDdapter.ViewHolder>() {
    private var tvs = emptyList<TV>()

    class ViewHolder(val binding: DbItemRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        DbItemRowBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tv = tvs[position]

        holder.binding.apply {
            if (tv.imageURL.isNotEmpty()) {
                Glide.with(holder.itemView.context)
                    .load(tv.imageURL)
                    .into(imgShow)
            } else {
                imgShow.setImageResource(R.drawable.ic_baseline_no_photography_24)
            }

            tvShowName.text = tv.title
            tvShowLanguage.text = tv.language

            llMain.setOnClickListener {
                Toast.makeText(holder.itemView.context, tv.summary, Toast.LENGTH_SHORT).show()
            }

            deleteBtn.setOnClickListener {
                dbActivity.deleteFromDB(tv)
            }
        }
    }

    override fun getItemCount(): Int = tvs.size

    fun updateShows(list: List<TV>) {
        this.tvs = list
        notifyDataSetChanged()
    }

}