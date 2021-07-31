package com.example.doracachesample.weather.biz

import android.content.Context
import com.example.doracachesample.weather.daily.DailyModel
import dora.cache.repository.DoraDatabaseCacheRepository
import dora.cache.repository.Repository
import dora.http.DoraCallback
import dora.http.retrofit.DoraRetrofitManager

@Repository(isListMode = false)
class DailyRepository(context: Context) : DoraDatabaseCacheRepository<DailyModel>(context) {

    override fun onLoadFromNetwork(callback: DoraCallback<DailyModel>) {
        DoraRetrofitManager.getService(WeatherService::class.java).getDaily().enqueue(callback)
    }
}