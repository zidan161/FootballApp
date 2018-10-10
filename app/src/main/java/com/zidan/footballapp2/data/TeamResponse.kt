package com.zidan.footballapp2.data

import com.google.gson.annotations.SerializedName

data class TeamResponse(@SerializedName("teams") var teams: List<Team>)