package com.example.dcache.biz.weather

import com.example.dcache.model.DailyModel
import com.example.dcache.model.HourlyModel
import com.example.dcache.model.MinutelyModel
import com.example.dcache.model.RealTimeModel
import com.example.dcache.model.WeatherModel
import dora.http.retrofit.ApiService
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * baseUrl: https://api.caiyunapp.com/v2.5/Pezyxsyn6yccBaZd/
 */
interface WeatherService : ApiService {

    @GET("{latlng}/weather.json")
    fun getWeather(@Path("latlng") latlng: String) : Call<WeatherModel>

    @GET("{latlng}/realtime.json")
    fun getRealTime(@Path("latlng") latlng: String) : Call<RealTimeModel>

    @GET("{latlng}/minutely.json")
    fun getMinutely(@Path("latlng") latlng: String) : Call<MinutelyModel>

    @GET("{latlng}/hourly.json")
    fun getHourly(@Path("latlng") latlng: String) : Observable<HourlyModel>

    @GET("{latlng}/daily.json")
    fun getDaily(@Path("latlng") latlng: String) : Call<DailyModel>
}