package com.example.dcache.repository

import android.content.Context
import com.example.dcache.biz.weather.WeatherService
import com.example.dcache.model.DailyModel
import dora.cache.repository.DoraDatabaseCacheRepository
import dora.cache.repository.Repository
import dora.http.DoraCallback
import dora.http.retrofit.DoraRetrofitManager

@Repository(isListMode = false)
class DailyRepository(context: Context) : DoraDatabaseCacheRepository<DailyModel>(context) {

    var latlng: String = ""

    override fun onLoadFromNetwork(callback: DoraCallback<DailyModel>) {
        DoraRetrofitManager.getService(WeatherService::class.java).getDaily(latlng).enqueue(callback)
    }
}