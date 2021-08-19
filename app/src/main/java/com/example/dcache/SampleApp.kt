package com.example.dcache

import android.app.Application
import com.example.dcache.biz.orm.Account
import com.example.dcache.model.WeatherModel
import com.example.dcache.repository.WeatherRepository
import com.example.dcache.model.DailyModel
import com.example.dcache.model.HourlyModel
import com.example.dcache.model.MinutelyModel
import com.example.dcache.model.RealTimeModel
import com.example.dcache.model.common.Temperature
import com.lwh.jackknife.CrashReport
import dora.cache.MemoryCache
import dora.db.Orm
import dora.db.OrmConfig

class SampleApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initConfig()
    }

    private fun initConfig() {
        CrashReport.init(this)
        Orm.init(this, OrmConfig.Builder()
                .database("dcache_sample")
                .tables(Account::class.java, WeatherModel::class.java, RealTimeModel::class.java,
                    MinutelyModel::class.java, HourlyModel::class.java, DailyModel::class.java,
                    Temperature::class.java)
                .version(1)
                .build())
        MemoryCache.scan(WeatherRepository::class.java)
    }
}