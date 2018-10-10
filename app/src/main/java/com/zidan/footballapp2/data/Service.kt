package com.zidan.footballapp2.data

import com.zidan.footballapp2.BuildConfig
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Service {

    @GET("api/v1/json/1/{time}.php")
    fun getEvents(@Path("time")time: String, @Query("id") id : String): Call<LeagueResponse>

    @GET("api/v1/json/1/lookupteam.php")
    fun getImageTeam(@Query("id") id: String): Call<TeamResponse>

    companion object Factory {

        fun create(): Service {
            val retrofit: Retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BuildConfig.BASE_URL)
                    .build()

            return retrofit.create(Service::class.java)
        }
    }
}