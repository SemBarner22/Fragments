package com.example.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.example.fragments.fragments.ChatFragment
import com.example.fragments.fragments.DictFragment
import com.example.fragments.fragments.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_chat.*
import kotlinx.android.synthetic.main.fragment_dict.*


class MainActivity : AppCompatActivity() {
    private var bottomNavManager: BottomNavManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupNavigationManager()
    }

    private fun setupNavigationManager() {
        bottomNavManager?.setupNavController() ?: kotlin.run {
            bottomNavManager = BottomNavManager(
                fragmentManager = supportFragmentManager,
                containerId = R.id.my_nav_host_fragment,
                bottomNavigationView = findViewById(R.id.bottom_navigation)
            )
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        bottomNavManager?.onSaveInstanceState(outState)
    }

    fun onBackPressed(view: View?) {
        onBackPressed()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        bottomNavManager?.onRestoreInstanceState(savedInstanceState)
        setupNavigationManager()
    }

    override fun onBackPressed() {
//        Log.e("wfwf", "ef")
        supportFragmentManager.fragments.forEach { fragment ->
//            Log.e(fragment.tag, fragment.tag)
//            if (fragment != null) {
//                if (fragment is Fragment) {
//                    Log.e("wfwf", "qqqqq")
//                    if (fragment.tag == "BottomNavManager#$2") {
//                        Log.e("wfwf", "eeeeeeee")
//                        if (numb.text.toString().toInt() == 0) {
//                            Log.e("wfwf", "evdvsdsvssdvdsv")
//                            if (bottomNavManager?.onBackPressed(fragment) == false) super.onBackPressed()
//                        }
//                    }
//                    if (fragment.tag == "BottomNavManager#$1") {
//                        Log.e("wfwf", "tretert")
//                        if (dict_num.text.toString().toInt() == 0) {
//                            if (bottomNavManager?.onBackPressed(fragment) == false) super.onBackPressed()
//                        }
//                    }
                    if (fragment.childFragmentManager.backStackEntryCount > 0) {
                        fragment.childFragmentManager.popBackStack()
                        return
                    } else {
                    super.onBackPressed()
                    }
                if (bottomNavManager?.onBackPressed(fragment) == false) super.onBackPressed()
                }
//            }
//        }
    }
}
//    private var currentNavController: LiveData<NavController>? = null
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        if (savedInstanceState == null) {
//            setupBottomNavigation()
//        }
//    }
//
//
//    override fun onSupportNavigateUp(): Boolean {
//        return currentNavController?.value?.navigateUp() ?: false
//    }
//
//    override fun onConfigurationChanged(newConfig: Configuration) {
//        super.onConfigurationChanged(newConfig)
//        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show()
//            val navigation =
//                findViewById<BottomNavigationView>(R.id.bottom_navigation)
//            navigation.rotation = 90f
//            navigation.layoutParams.width = 480
//            navigation.requestLayout()
//            navigation.y = navigation.y - 500f
//            navigation.requestLayout();
//            val menuView =
//                navigation.getChildAt(0) as BottomNavigationMenuView
//            for (i in 0 until menuView.childCount) {
//                val iconView = menuView.getChildAt(i)
//                iconView.rotation = -90f
//            }
//        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
//            recreate()
//        }
//    }
//
//    private fun setupBottomNavigation() {
//        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
//        val navGraphIds = listOf(
//            R.navigation.home_navigation,
//            R.navigation.dict_navigation,
//            R.navigation.chat_navigation
//        )
//        val controller = bottomNavigationView.setupWithNavController(
//            navGraphIds = navGraphIds,
//            fragmentManager = supportFragmentManager,
//            containerId = R.id.my_nav_host_fragment,
//            intent = intent
//        )
//        currentNavController = controller
//    }
//
//
//
//
//
//
//    fun onBackPressed(view: View?) {
//        onBackPressed()
//    }
//
//    //    override fun onSaveInstanceState(outState: Bundle) {
////        super.onSaveInstanceState(outState)
////        outState.putString("id", bottom_navigation.selectedItemId.toString())
////    }
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
////        bottom_navigation.selectedItemId = savedInstanceState["id"].toString().toInt()
////        bottom_navigation.
//        setupBottomNavigation()
//    }

