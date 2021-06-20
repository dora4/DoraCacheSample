package com.example.doracachesample

import android.app.Application
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
                .tables(Account::class.java)
                .version(1)
                .build())
    }
}