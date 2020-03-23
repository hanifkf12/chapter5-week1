package com.hanifkf12.myw2application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object{
        const val TAG = "MainActivity"
    }
    var name = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        savedInstanceState?.let {
            name = it.getString("name").toString()
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Intent().apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
//            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
        navigateFragment(HomeFragment())
        supportActionBar?.title = "Home"
        bottom_nav_menu.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home->{
                    Log.d(TAG,"navigation home")
                    navigateFragment(HomeFragment())
                    supportActionBar?.title = "Home"
                }
                R.id.nav_search->{
                    Log.d(TAG,"navigation search")
                    navigateFragment(SearchFragment())
                    supportActionBar?.title = "Search"

                }
                R.id.nav_notification->{
                    Log.d(TAG,"navigation notification")
                    navigateFragment(NotificationFragment())
                    supportActionBar?.title = "Notification"
                }
                R.id.nav_profile->{
                    Log.d(TAG,"navigation profile")
                    navigateFragment(ProfileFragment())
                    supportActionBar?.title = "Profile"
                }
            }
            true
        }
    }
    private fun navigateFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container_fragment,fragment)
            commit()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("name", name)
    }
}
