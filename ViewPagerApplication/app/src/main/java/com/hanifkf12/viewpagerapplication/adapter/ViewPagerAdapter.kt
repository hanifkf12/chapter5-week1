package com.hanifkf12.viewpagerapplication.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.hanifkf12.viewpagerapplication.landing.FirstFragment
import com.hanifkf12.viewpagerapplication.landing.SecondFragment
import com.hanifkf12.viewpagerapplication.landing.ThirdFragment


class ViewPagerAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    private val fragments = arrayOf(
        FirstFragment(),
        SecondFragment(),
        ThirdFragment()
    )
    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

}