package com.example.dcache.repository

import android.content.Context
import com.example.dcache.biz.weather.WeatherService
import com.example.dcache.model.WeatherModel
import dora.cache.data.fetcher.OnLoadStateListener
import dora.cache.repository.DoraDatabaseCacheRepository
import dora.cache.repository.Repository
import dora.http.DoraCallback
import dora.http.retrofit.RetrofitManager

@Repository
class WeatherRepository(context: Context) : DoraDatabaseCacheRepository<WeatherModel>(context) {

    var latlng: String = ""

    override fun onLoadFromNetwork(
        callback: DoraCallback<WeatherModel>,
        listener: OnLoadStateListener?
    ) {
        RetrofitManager.getService(WeatherService::class.java).getWeather(latlng).enqueue(callback)
    }
}