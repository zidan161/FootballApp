package com.zidan.footballapp2.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class League (

        @SerializedName("idHomeTeam")
        var homeId : Int? = null,

        @SerializedName("idAwayTeam")
        var awayId : Int? = null,

        @SerializedName("dateEvent")
        var date : Date? = null,

        @SerializedName("strHomeTeam")
        var homeName : String? = null,

        @SerializedName("strAwayTeam")
        var awayName : String? = null,

        @SerializedName("intHomeScore")
        var homeScore : Int? = null,

        @SerializedName("intAwayScore")
        var awayScore : Int? = null,

        @SerializedName("strHomeGoalDetails")
        var goalsHome : String? = null,

        @SerializedName("strAwayGoalDetails")
        var goalsAway : String? = null,

        @SerializedName("strHomeShots")
        var shotsHome : String? = null,

        @SerializedName("strAwayShots")
        var shotsAway : String? = null,

        @SerializedName("strHomeLineupGoalkeeper")
        var homeGoalKeeper : String? = null,

        @SerializedName("strAwayLineupGoalkeeper")
        var awayGoalKeeper : String? = null,

        @SerializedName("strHomeLineupDefense")
        var homeDefense : String? = null,

        @SerializedName("strAwayLineupDefense")
        var awayDefense : String? = null

): Parcelable