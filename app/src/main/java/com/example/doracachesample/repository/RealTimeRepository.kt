package com.example.doracachesample.repository

import android.content.Context
import com.example.doracachesample.biz.weather.WeatherService
import com.example.doracachesample.model.RealTimeModel
import dora.cache.repository.DoraDatabaseCacheRepository
import dora.cache.repository.Repository
import dora.http.DoraCallback
import dora.http.retrofit.DoraRetrofitManager

@Repository(isListMode = false)
class RealTimeRepository(context: Context) : DoraDatabaseCacheRepository<RealTimeModel>(context) {

    var latlng: String = ""

    override fun onLoadFromNetwork(callback: DoraCallback<RealTimeModel>) {
        DoraRetrofitManager.getService(WeatherService::class.java).getRealTime(latlng).enqueue(callback)
    }
}