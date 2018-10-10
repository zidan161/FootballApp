package com.zidan.footballapp2.data

import com.google.gson.annotations.SerializedName

data class LeagueResponse (@SerializedName("events")var events: List<League>)