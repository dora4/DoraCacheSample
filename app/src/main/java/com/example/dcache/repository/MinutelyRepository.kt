package com.example.dcache.repository

import android.content.Context
import com.example.dcache.biz.weather.WeatherService
import com.example.dcache.model.MinutelyModel
import dora.cache.repository.DoraDatabaseCacheRepository
import dora.cache.repository.Repository
import dora.http.DoraCallback
import dora.http.retrofit.RetrofitManager

@Repository(isListMode = false, isLogPrint = true)
class MinutelyRepository(context: Context) : DoraDatabaseCacheRepository<MinutelyModel>(context) {

    var latlng: String = ""

    override fun onLoadFromNetwork(callback: DoraCallback<MinutelyModel>) {
        RetrofitManager.getService(WeatherService::class.java).getMinutely(latlng).enqueue(callback)
    }
}