package com.example.horseracing

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class HorseAdapter(private val horseList: List<Horse>) : RecyclerView.Adapter<HorseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorseViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.horse_list_item, parent, false)
        return HorseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HorseViewHolder, position: Int) {
        val horse = horseList[position]
        holder.bind(horse)
    }

    override fun getItemCount(): Int {
        return horseList.size
    }


}