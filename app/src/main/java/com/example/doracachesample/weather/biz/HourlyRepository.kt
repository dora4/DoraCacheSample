package com.example.doracachesample.weather.biz

import android.content.Context
import com.example.doracachesample.weather.hourly.HourlyModel
import dora.cache.repository.DoraDatabaseCacheRepository
import dora.cache.repository.Repository
import dora.http.DoraCallback
import dora.http.retrofit.DoraRetrofitManager

@Repository(isListMode = false)
class HourlyRepository(context: Context) : DoraDatabaseCacheRepository<HourlyModel>(context) {

    var latlng: String = ""

    override fun onLoadFromNetwork(callback: DoraCallback<HourlyModel>) {
        DoraRetrofitManager.getService(WeatherService::class.java).getHourly(latlng).enqueue(callback)
    }
}