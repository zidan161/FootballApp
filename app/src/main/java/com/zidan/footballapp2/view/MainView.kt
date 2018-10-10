package com.zidan.footballapp2.view

import com.zidan.footballapp2.data.League

interface MainView {

    fun showLoading()
    fun hideLoading()
    fun showEventList(data: List<League>)
}