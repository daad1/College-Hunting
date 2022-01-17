package com.example.daadalotaibi_beltexam.RVAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.daadalotaibi_beltexam.APIFragment
import com.example.daadalotaibi_beltexam.Database.TV
import com.example.daadalotaibi_beltexam.Model.ShowResponseItem
import com.example.daadalotaibi_beltexam.databinding.ItemRowBinding

class RVAdapter (private val activity: APIFragment) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {
    private var shows = emptyList<ShowResponseItem>()

    class ViewHolder(val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemRowBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val show = shows[position]

        holder.binding.apply {
            showBtn.text = show.show.name
            showBtn.setOnClickListener {
                when {
                    show.show.image == null -> {
                        activity.addToDB(
                            TV(
                                0,
                                show.show.name,
                                show.show.language!!,
                                show.show.summary!!,
                                ""
                            )
                        )
                    }
                    show.show.summary == null -> {
                        activity.addToDB(
                            TV(
                                0,
                                show.show.name,
                                show.show.language!!,
                                "",
                                show.show.image!!.original
                            )
                        )
                    }
                    show.show.language == null -> {
                        activity.addToDB(
                            TV(
                                0,
                                show.show.name,
                                "",
                                show.show.summary,
                                show.show.image!!.original
                            )
                        )
                    }
                    show.show.summary == null && show.show.image == null -> {
                        activity.addToDB(TV(0, show.show.name, show.show.language, "", ""))
                    }
                    show.show.language == null && show.show.image == null -> {
                        activity.addToDB(TV(0, show.show.name, "", show.show.summary, ""))
                    }
                    show.show.summary == null && show.show.language == null -> {
                        activity.addToDB(TV(0, show.show.name, "", "", show.show.image!!.original))
                    }

                    (show.show.summary == null && show.show.language == null) && show.show.image == null -> {
                        activity.addToDB(TV(0, show.show.name, "", "", ""))
                    }

                    else -> {
                        activity.addToDB(
                            TV(
                                0,
                                show.show.name,
                                show.show.language,
                                show.show.summary,
                                show.show.image!!.original
                            )
                        )
                    }
                }
                Toast.makeText(holder.itemView.context, "Added To Database", Toast.LENGTH_SHORT)
                    .show()
            }

        }
    }

    override fun getItemCount(): Int = shows.size

    fun updateShows(list: List<ShowResponseItem>) {
        this.shows = list
        notifyDataSetChanged()
    }

}