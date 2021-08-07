package com.example.doracachesample.weather.biz

import com.example.doracachesample.weather.daily.DailyModel
import com.example.doracachesample.weather.hourly.HourlyModel
import com.example.doracachesample.weather.minutely.MinutelyModel
import com.example.doracachesample.weather.realtime.RealTimeModel
import dora.http.retrofit.ApiService
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * baseUrl: https://api.caiyunapp.com/v2.5/Pezyxsyn6yccBaZd/121.6544,25.1552/
 */
interface WeatherService : ApiService {

    @GET("{latlng}/weather.json")
    fun getWeather(@Path("latlng") latlng: String) : Call<WeatherModel>

    @GET("{latlng}/realtime.json")
    fun getRealTime(@Path("latlng") latlng: String) : Call<RealTimeModel>

    @GET("{latlng}/minutely.json")
    fun getMinutely(@Path("latlng") latlng: String) : Call<MinutelyModel>

    @GET("{latlng}/hourly.json")
    fun getHourly(@Path("latlng") latlng: String) : Call<HourlyModel>

    @GET("{latlng}/daily.json")
    fun getDaily(@Path("latlng") latlng: String) : Call<DailyModel>
}