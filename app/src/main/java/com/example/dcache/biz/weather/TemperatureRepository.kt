package com.example.dcache.biz.weather

import android.content.Context
import com.example.dcache.model.DailyModel
import com.example.dcache.model.common.Temperature
import dora.cache.data.fetcher.OnLoadStateListener
import dora.cache.repository.DoraDatabaseCacheRepository
import dora.cache.repository.DoraFlowDatabaseCacheRepository
import dora.cache.repository.ListRepository
import dora.db.builder.Condition
import dora.db.builder.WhereBuilder
import dora.http.DoraCallback
import dora.http.DoraListCallback
import dora.http.retrofit.RetrofitManager

@ListRepository(isLogPrint = true)
class TemperatureRepository(context: Context) : DoraFlowDatabaseCacheRepository<Temperature>(context) {

    var latlng: String = ""
    var addr: String = ""

    override fun where(): Condition {
        return WhereBuilder.create().addWhereEqualTo("latlng", latlng)
                .andWhereEqualTo("addr", addr).toCondition()
    }

    override fun onLoadFromNetwork(
        callback: DoraListCallback<Temperature>,
        listener: OnLoadStateListener?
    ) {
        // 适配数据
        RetrofitManager.getService(WeatherService::class.java).getDaily(latlng).enqueue(object
            : DoraCallback<DailyModel>() {

            override fun onFailure(msg: String) {
                callback.onFailure(msg)
                // 因为fetchData中指定了listener，所以要回调
                listener?.onLoad(OnLoadStateListener.FAILURE)
            }

            override fun onSuccess(model: DailyModel) {
                // 因为fetchData中指定了listener，所以要回调
                listener?.onLoad(OnLoadStateListener.SUCCESS)
                model.result?.daily?.apply {
                    if (temperature != null) {
                        for (t in temperature!!) {
                            t.latlng = latlng
                            t.addr = addr
                        }
                        callback.onSuccess(temperature!!)
                    }
                }
            }
        })
    }
}