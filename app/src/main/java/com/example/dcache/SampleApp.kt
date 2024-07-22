package com.example.dcache

import android.app.Application
import com.example.dcache.biz.orm.TestCaseModel
import com.example.dcache.model.WeatherModel
import com.example.dcache.model.DailyModel
import com.example.dcache.model.HourlyModel
import com.example.dcache.model.MinutelyModel
import com.example.dcache.model.RealTimeModel
import com.example.dcache.model.common.Temperature
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
                .tables(TestCaseModel::class.java)
                .version(1)
                .build())
    }
}