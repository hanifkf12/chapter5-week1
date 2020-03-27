package com.hanifkf12.myfragmentcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), FirstFragmentInterface, SecondFragmentInterface {

    val firstFragment = FirstFragment.newInstance()
    val secondFragment = SecondFragment.newInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container1, firstFragment)
            commit()
        }
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container2,secondFragment)
            commit()
        }
    }

    override fun showAddtoSecond(count: Int) {
        secondFragment.setCount(count)
    }

    override fun showMintoSecond(count: Int) {
        secondFragment.setCount(count)
    }

    override fun showAddtoFirst(count: Int) {
        firstFragment.setCountFirst(count)
    }

    override fun showMintoFirst(count: Int) {
        firstFragment.setCountFirst(count)

    }
}
