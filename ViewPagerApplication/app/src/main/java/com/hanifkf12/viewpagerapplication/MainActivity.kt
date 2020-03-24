package com.hanifkf12.viewpagerapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.hanifkf12.viewpagerapplication.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var indexPage = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter =
            ViewPagerAdapter(
                supportFragmentManager
            )
        viewPager.adapter = adapter
        dotIndicator.setViewPager(viewPager)

        prev.visibility = View.GONE
        next.visibility = View.VISIBLE
        finish.visibility = View.GONE
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
               indexPage = position
                Log.d("POSITIOIN", indexPage.toString())
                if(indexPage>0){
                    prev.visibility = View.VISIBLE
                    if(indexPage==2){
                        next.visibility = View.GONE
                        finish.visibility = View.VISIBLE
                    }else if(indexPage<2){
                        next.visibility = View.VISIBLE
                        finish.visibility = View.GONE
                    }
                }else{
                    prev.visibility = View.GONE
                    next.visibility = View.VISIBLE
                    finish.visibility = View.GONE
                }
            }

        })
        prev.setOnClickListener {
            viewPager.currentItem = indexPage-1
        }
        next.setOnClickListener {
            viewPager.currentItem = indexPage + 1
        }
        finish.setOnClickListener {
            //intent
//            System.exit(0)
        }

    }
}
