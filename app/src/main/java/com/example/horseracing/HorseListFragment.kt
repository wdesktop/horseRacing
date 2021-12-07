package com.example.horseracing

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val TAGLIST: String = "ListFragment"
private const val POSITION = "ListRecyclerScroll"
private var currentVisiblePosition: String = "0"

lateinit var horseRecyclerView: RecyclerView
val horseList:List<Horse> = listOf(
    Horse(0, "Arabic horse", R.drawable.horce_arabik, "Riding", "Elite horse riding", "Arabic emirat"),
    Horse(1, "Mustang horse", R.drawable.horce_mustang, "Riding", "Wild horse riding", "America"),
    Horse(2, "Ahaltekinets horse", R.drawable.horse_ahaltekinets, "Riding", "Ahaltekinets horse riding", "Kavkaz"),
    Horse(3, "Pinto horse", R.drawable.horse_pinto, "Riding", "Smal mongol horse riding", "Egypt"),
    Horse(4, "Mongol horse", R.drawable.horse_mongol, "Riding", "Smal mongol horse riding", "Tartaria"),
    Horse(5, "Shair horse", R.drawable.horse_shair, "Heavy Truck", "Big heavy truck horse", "British")
)

class HorseListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (savedInstanceState != null) {
             if (savedInstanceState.getString(POSITION) != null) {
                 currentVisiblePosition = savedInstanceState.getString(POSITION)!!
             }
        }
        //Log.d(TAGLIST, "!!! onCreateView - $currentVisiblePosition")

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_horse_list, container, false)
        horseRecyclerView = view.findViewById(R.id.horse_recycler_view)

        // resize recycler icons when rotating monitor
        val orient = (activity as MainActivity).getScreenOrientation()
        if (orient == "VERTICAL") {
            horseRecyclerView.layoutManager =
                LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        } else {
            horseRecyclerView.layoutManager =
                LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        }
        (horseRecyclerView.layoutManager as LinearLayoutManager).scrollToPosition(currentVisiblePosition.toInt())
        horseRecyclerView.adapter = HorseAdapter(horseList)

        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // get & save position RecyclerView for sleep app & Rotate monitor
        currentVisiblePosition =
            (horseRecyclerView.getLayoutManager() as LinearLayoutManager).findFirstCompletelyVisibleItemPosition().toString()
        outState.putString(POSITION, currentVisiblePosition)
        bundle.putString(KEY, TAGLIST)

    }

    override fun onPause() {
        super.onPause()
        // get & save position RecyclerView for change HelpFragment & PageFragment
        currentVisiblePosition =
            (horseRecyclerView.getLayoutManager() as LinearLayoutManager).findFirstCompletelyVisibleItemPosition().toString()
        bundle.putString(KEY, TAGLIST)

    }
}