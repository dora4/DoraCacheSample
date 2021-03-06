package com.example.dcache.biz.weather

import android.content.Context
import com.example.dcache.model.DailyModel
import com.example.dcache.model.common.Temperature
import dora.cache.repository.BaseNoCacheRepository
import dora.cache.repository.DoraDatabaseCacheRepository
import dora.cache.repository.Repository
import dora.db.builder.Condition
import dora.db.builder.WhereBuilder
import dora.http.DoraCallback
import dora.http.DoraListCallback
import dora.http.retrofit.RetrofitManager

@Repository(isListMode = true, isLogPrint = true)
class TemperatureRepository(context: Context) : DoraDatabaseCacheRepository<Temperature>(context) {

    var latlng: String = ""
    var addr: String = ""

    override fun where(): Condition {
        return WhereBuilder.create().addWhereEqualTo("latlng", latlng)
                .andWhereEqualTo("addr", addr).toCondition()
    }

    override fun onLoadFromNetwork(callback: DoraListCallback<Temperature>) {
        // 适配数据
        RetrofitManager.getService(WeatherService::class.java).getDaily(latlng).enqueue(object
            : DoraCallback<DailyModel>() {

            override fun onFailure(code: Int, msg: String?) {
                callback.onFailure(code, msg)
            }

            override fun onSuccess(model: DailyModel) {
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