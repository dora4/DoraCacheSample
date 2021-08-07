package com.example.doracachesample.weather.biz

import android.content.Context
import dora.cache.repository.DoraDatabaseCacheRepository
import dora.cache.repository.Repository
import dora.http.DoraCallback
import dora.http.retrofit.DoraRetrofitManager

@Repository(isListMode = false)
class WeatherRepository(context: Context) : DoraDatabaseCacheRepository<WeatherModel>(context) {

    var latlng: String = ""

    override fun onLoadFromNetwork(callback: DoraCallback<WeatherModel>) {
        DoraRetrofitManager.getService(WeatherService::class.java).getWeather(latlng).enqueue(callback)
    }
}