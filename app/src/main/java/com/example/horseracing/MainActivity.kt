package com.example.horseracing

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout

private const val TAGLIST = "MainActivity"
const val KEY = "TAGLIST"
private const val LAST_SELECTED_ITEM = "item"

var horseIndex:Int = 0
var bundle = Bundle()

class MainActivity : AppCompatActivity() {


    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fragment: Fragment? = null

        bottomNavigationView = findViewById(R.id.bottom_navigation_view)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> { fragment = HorseListFragment() }
                R.id.menu_help -> { fragment = HorseHelpFragment() }
            }
            replaceFragment(fragment!!)
            true
        }

        if (bundle.getString(KEY) != null) {
            when (bundle.getString(KEY)) {
                "ListFragment" -> { fragment = HorseListFragment() }
                "PageFragment" -> { fragment = HorsePageFragment() }
                "HelpFragment" -> { fragment = HorseHelpFragment() }
                else -> { fragment = HorseListFragment() }
            }
            replaceFragment(fragment!!)

        } else {
            bottomNavigationView.selectedItemId =
                savedInstanceState?.getInt(LAST_SELECTED_ITEM) ?: R.id.menu_home
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_SELECTED_ITEM, bottomNavigationView.selectedItemId)
    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    fun getScreenOrientation(): String {
        return when (resources.configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> "VERTICAL"
            Configuration.ORIENTATION_LANDSCAPE -> "HORIZONTAL"
            else -> "VERTICAL"
        }
    }


}
