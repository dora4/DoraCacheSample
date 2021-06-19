package com.example.doracachesample

import android.app.Application
import dora.db.OrmConfig

class SampleApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initConfig()
    }

    private fun initConfig() {
        OrmConfig.Builder()
            .database("dcache_sample")
            .version(1)
            .build()
    }
}