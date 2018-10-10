package com.zidan.footballapp2.data

import com.google.gson.annotations.SerializedName

data class Team(

        @SerializedName("strTeamBadge")
        var teamImage: String? = null
)