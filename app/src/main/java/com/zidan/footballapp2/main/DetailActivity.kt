package com.zidan.footballapp2.main

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.squareup.picasso.Picasso
import com.zidan.footballapp2.data.League
import com.zidan.footballapp2.R
import com.zidan.footballapp2.data.Service
import com.zidan.footballapp2.data.TeamResponse
import kotlinx.android.synthetic.main.activity_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val intent: Intent = intent
        val data = intent.getParcelableExtra<League>("data")

        setView(data)
    }

    @SuppressLint("SimpleDateFormat")
    private fun setView(data: League) {

        home_name.text = data.homeName
        away_name.text = data.awayName

        val date = data.date
        val eventDate = SimpleDateFormat("dd MMM yyyy").format(date)
        date_events.text = eventDate

        val homeScore = data.homeScore.toString()
        val awayScore = data.awayScore.toString()

        if (homeScore == "null"){
            home_score.text = ""
            away_score.text = ""
        } else {
            home_score.text = homeScore
            away_score.text = awayScore
        }

        goals_home.text = data.goalsHome
        goals_away.text = data.goalsAway

        shot_home.text = data.shotsHome
        shot_away.text = data.shotsAway

        goal_keeper_home.text = data.homeGoalKeeper
        goal_keeper_away.text = data.awayGoalKeeper

        defense_home.text = data.awayDefense
        defense_away.text = data.homeDefense

        getImage(data.homeId.toString(), "home")
        getImage(data.awayId.toString(), "away")
    }

    private fun getImage(id: String, team: String){

        val service = Service.create()
        val call = service.getImageTeam(id)

        call.enqueue(object : Callback<TeamResponse> {

            override fun onFailure(call: Call<TeamResponse>, t: Throwable) {
                Log.d("error", t.toString())
            }

            override fun onResponse(call: Call<TeamResponse>, response: Response<TeamResponse>) {
                val data = response.body()!!.teams[0].teamImage
                if (team == "home"){
                    Picasso.get().load(data).into(home_badge)
                } else {
                    Picasso.get().load(data).into(away_badge)
                }
            }
        })
    }
}
