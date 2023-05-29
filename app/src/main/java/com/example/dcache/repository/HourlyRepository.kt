package com.example.dcache.repository

import android.content.Context
import com.example.dcache.biz.weather.WeatherService
import com.example.dcache.model.HourlyModel
import dora.cache.data.fetcher.OnLoadStateListener
import dora.cache.repository.DoraDatabaseCacheRepository
import dora.cache.repository.Repository
import dora.http.retrofit.RetrofitManager
import io.reactivex.Observable

@Repository(isListMode = false)
class HourlyRepository(context: Context) : DoraDatabaseCacheRepository<HourlyModel>(context) {

    var latlng: String = ""

    override fun onLoadFromNetworkObservable(listener: OnLoadStateListener?): Observable<HourlyModel> {
        return RetrofitManager.getService(WeatherService::class.java).getHourly(latlng)
    }
}