package com.example.dcache.repository

import android.content.Context
import com.example.dcache.biz.weather.WeatherService
import com.example.dcache.model.WeatherModel
import dora.cache.repository.DoraMemoryCacheRepository
import dora.cache.repository.Repository
import dora.http.DoraCallback
import dora.http.retrofit.DoraRetrofitManager

@Repository(isListMode = false)
class WeatherRepository(context: Context) : DoraMemoryCacheRepository<WeatherModel>(context) {

    var latlng: String = ""

    override fun onLoadFromNetwork(callback: DoraCallback<WeatherModel>) {
        DoraRetrofitManager.getService(WeatherService::class.java).getWeather(latlng).enqueue(callback)
    }

    override val cacheName: String
        get() = "WeatherRepository"
}