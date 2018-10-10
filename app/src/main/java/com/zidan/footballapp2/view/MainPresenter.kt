package com.zidan.footballapp2.view

import com.zidan.footballapp2.data.LeagueResponse
import com.zidan.footballapp2.view.MainView
import com.zidan.footballapp2.data.Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(private val view: MainView) {

    fun getLeagueList(time: String, id: String) {

        view.showLoading()

        val service = Service.create()
        val call = service.getEvents(time, id)

        call.enqueue(object : Callback<LeagueResponse> {

            override fun onFailure(call: Call<LeagueResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<LeagueResponse>, response: Response<LeagueResponse>) {
                val data = response.body()!!.events
                view.hideLoading()
                view.showEventList(data)
            }
        })
    }
}