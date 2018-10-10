package com.zidan.footballapp2.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.zidan.footballapp2.adapter.FragmentAdapter
import com.zidan.footballapp2.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewpager_main.adapter = FragmentAdapter(supportFragmentManager)
        tabs_main.setupWithViewPager(viewpager_main)
    }
}
