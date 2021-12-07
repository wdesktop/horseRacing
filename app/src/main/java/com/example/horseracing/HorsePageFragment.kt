package com.example.horseracing

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

private const val TAGLIST: String = "PageFragment"

class HorsePageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_horse_page, container, false)

        //Log.d(TAGPAGE, "!!! onCreateView - $horseIndex")
        val horse_img: ImageView = view.findViewById(R.id.horse_page_image)
        val horse_breed: TextView = view.findViewById(R.id.horse_page_breed)
        val horse_type: TextView = view.findViewById(R.id.horse_page_type)
        val horse_description: TextView = view.findViewById(R.id.horse_page_description)
        val horse_country: TextView = view.findViewById(R.id.horse_page_country)

        horse_breed.text = horseList[horseIndex].breed
        horse_type.text = horseList[horseIndex].type
        horse_description.text = horseList[horseIndex].description
        horse_country.text = horseList[horseIndex].country
        horse_img.setImageResource(horseList[horseIndex].image)

        return view
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //outState.putString(KEY, TAGLIST)
        bundle.putString(KEY, TAGLIST)

        //Log.d(TAGLIST, "!!! onSaveInst - $TAGLIST")

    }

}

