package com.example.weatherapplication.viewmodel


import com.example.weatherapplication.model.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("weather")
    fun getWeather(@Query("q")location:String, @Query("appid")apiKey:String): Call<WeatherResponse>
}