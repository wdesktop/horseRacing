package com.example.horseracing

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager

private const val TAGLIST: String = "HelpFragment"

class HorseHelpFragment : Fragment() {
    lateinit var devSiteButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_horse_help, container, false)
        val activity: Context = view.context
        val link = Uri.parse("https://google.ru/search?q=лошади")
        devSiteButton = view.findViewById(R.id.developer_site)

        devSiteButton.setOnClickListener {
            val openBrowserIntent: Intent = Intent(Intent.ACTION_VIEW, link)
            activity.startActivity(openBrowserIntent)
        }
        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //outState.putString(KEY, TAGLIST)
        bundle.putString(KEY, TAGLIST)

        Log.d(TAGLIST, "!!! onSaveInst - $TAGLIST")

    }

}