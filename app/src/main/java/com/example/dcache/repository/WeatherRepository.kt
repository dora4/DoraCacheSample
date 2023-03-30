package com.example.dcache.repository

import android.content.Context
import com.example.dcache.biz.weather.WeatherService
import com.example.dcache.model.WeatherModel
import dora.cache.repository.DoraDatabaseCacheRepository
import dora.cache.repository.Repository
import dora.http.DoraCallback
import dora.http.retrofit.RetrofitManager

@Repository(isListMode = false)
class WeatherRepository(context: Context) : DoraDatabaseCacheRepository<WeatherModel>(context) {

    var latlng: String = ""

    override fun onLoadFromNetwork(callback: DoraCallback<WeatherModel>) {
        RetrofitManager.getService(WeatherService::class.java).getWeather(latlng).enqueue(callback)
    }
}