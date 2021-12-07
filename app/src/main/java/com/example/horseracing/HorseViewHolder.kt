package com.example.horseracing


import android.content.Context
import android.util.DisplayMetrics
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HorseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val horseImageView: ImageView = itemView.findViewById(R.id.horse_image_view)
    private val horseTextView: TextView = itemView.findViewById(R.id.horse_text_view)
    private var activity: Context = itemView.context

    fun Int.dpToPx(displayMetrics: DisplayMetrics): Int = (this * displayMetrics.density).toInt()
    //fun Int.pxToDp(displayMetrics: DisplayMetrics): Int = (this / displayMetrics.density).toInt()

    fun bind(horse: Horse) {
        horseTextView.text = horse.breed
        horseImageView.setImageResource(horse.image)

        // resize item for recycler icons
        val orient = (activity as MainActivity).getScreenOrientation()
        if (orient == "VERTICAL") {
            horseImageView.requestLayout();
            horseImageView.getLayoutParams().height = 180.dpToPx(activity.resources.displayMetrics)
            horseImageView.getLayoutParams().width = 300.dpToPx(activity.resources.displayMetrics)

        } else {
            horseImageView.requestLayout();
            horseImageView.getLayoutParams().height = 150.dpToPx(activity.resources.displayMetrics)
            horseImageView.getLayoutParams().width = 200.dpToPx(activity.resources.displayMetrics)
        }

        itemView.setOnClickListener {
            horseIndex = horse.id
            (activity as MainActivity).replaceFragment(HorsePageFragment())
        }
    }
}