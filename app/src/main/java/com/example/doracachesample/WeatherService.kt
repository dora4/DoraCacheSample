package com.example.doracachesample

import com.example.doracachesample.realtime.RealTimeModel
import com.example.doracachesample.weather.WeatherModel
import dora.http.retrofit.ApiService
import retrofit2.Call
import retrofit2.http.GET

/**
 * baseUrl: https://api.caiyunapp.com/v2.5/Pezyxsyn6yccBaZd/121.6544,25.1552/
 */
interface WeatherService : ApiService {

    @GET("weather.json")
    fun getWeather() : Call<WeatherModel>

    @GET("realtime.json")
    fun getRealTime() : Call<RealTimeModel>
}