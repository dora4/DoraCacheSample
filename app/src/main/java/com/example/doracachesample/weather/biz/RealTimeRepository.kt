package com.example.doracachesample.weather.biz

import android.content.Context
import com.example.doracachesample.weather.realtime.RealTimeModel
import dora.cache.repository.DoraDatabaseCacheRepository
import dora.cache.repository.Repository
import dora.http.DoraCallback
import dora.http.retrofit.DoraRetrofitManager

@Repository(isListMode = false)
class RealTimeRepository(context: Context) : DoraDatabaseCacheRepository<RealTimeModel>(context) {

    override fun onLoadFromNetwork(callback: DoraCallback<RealTimeModel>) {
        DoraRetrofitManager.getService(WeatherService::class.java).getRealTime().enqueue(callback)
    }
}