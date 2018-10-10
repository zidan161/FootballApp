package com.zidan.footballapp2.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.zidan.footballapp2.main.NextEventsFragment
import com.zidan.footballapp2.main.PastEventsFragment

class FragmentAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {

    private val pages = listOf<Fragment>(PastEventsFragment(), NextEventsFragment())

    override fun getItem(position: Int): Fragment = pages[position]

    override fun getCount(): Int = pages.size

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Past Events"
            else -> "Next Events"
        }
    }
}