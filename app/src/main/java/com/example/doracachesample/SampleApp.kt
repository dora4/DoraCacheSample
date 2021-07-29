package com.example.doracachesample

import android.app.Application
import com.example.doracachesample.weather.biz.WeatherModel
import com.example.doracachesample.weather.daily.DailyModel
import dora.bugskiller.DoraConfig
import dora.bugskiller.StoragePolicy
import dora.db.Orm
import dora.db.OrmConfig

class SampleApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initConfig()
    }

    private fun initConfig() {
        Orm.init(this, OrmConfig.Builder()
                .database("dcache_sample")
                .tables(Account::class.java, WeatherModel::class.java, DailyModel::class.java)
                .version(1)
                .build())
        DoraConfig.Builder(this).crashReportPolicy(StoragePolicy("DoraMusic/log")).build()
    }
}