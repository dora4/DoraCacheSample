package com.example.doracachesample.weather.biz

import android.content.Context
import com.example.doracachesample.weather.minutely.MinutelyModel
import dora.cache.repository.DoraDatabaseCacheRepository
import dora.cache.repository.Repository
import dora.http.DoraCallback
import dora.http.retrofit.DoraRetrofitManager

@Repository(isListMode = false)
class MinutelyRepository(context: Context) : DoraDatabaseCacheRepository<MinutelyModel>(context) {

    var latlng: String = ""

    override fun onLoadFromNetwork(callback: DoraCallback<MinutelyModel>) {
        DoraRetrofitManager.getService(WeatherService::class.java).getMinutely(latlng).enqueue(callback)
    }
}