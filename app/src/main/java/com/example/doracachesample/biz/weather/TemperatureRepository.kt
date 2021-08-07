package com.example.doracachesample.biz.weather

import android.content.Context
import com.example.doracachesample.model.DailyModel
import com.example.doracachesample.model.common.Temperature
import dora.cache.repository.DoraDatabaseCacheRepository
import dora.cache.repository.Repository
import dora.db.builder.Condition
import dora.db.builder.WhereBuilder
import dora.http.DoraCallback
import dora.http.DoraListCallback
import dora.http.retrofit.DoraRetrofitManager

@Repository(isListMode = true, isLogPrint = true)
class TemperatureRepository(context: Context) : DoraDatabaseCacheRepository<Temperature>(context) {

    var latlng: String = ""

    override fun where(): Condition {
        // 数据平移原则，通过latlng进行清除和读取
        // 原来的数据库版本：  0 1 2 3 4
        // 第2天：            1 2 3 4 5  （有网，清除0 1 2 3 4）， 0 1 2 3 4（无网，显示数据库的数据版本）
        // 第3天：              2 3 4 5 6（有网，清除0 1 2 3 4）， 0 1 2 3 4（无网，显示数据库的数据版本）
        return WhereBuilder.create().addWhereEqualTo("latlng", latlng).toCondition()
    }

    override fun onLoadFromNetwork(callback: DoraListCallback<Temperature>) {
        // 适配数据
        DoraRetrofitManager.getService(WeatherService::class.java).getDaily(latlng).enqueue(object
            : DoraCallback<DailyModel>() {

            override fun onFailure(code: Int, msg: String?) {
                callback.onFailure(code, msg)
            }

            override fun onSuccess(model: DailyModel) {
                model.result?.daily?.apply {
                    if (temperature != null) {
                        for (t in temperature!!) {
                            t.latlng = latlng
                        }
                        callback.onSuccess(temperature!!)
                    }
                }
            }
        })
    }
}