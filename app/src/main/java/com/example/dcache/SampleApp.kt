package com.example.dcache

import android.app.Application
import com.example.dcache.biz.orm.TestCaseModel
import com.example.dcache.biz.orm.TestCaseModel2
import com.example.dcache.biz.orm.TestCaseModel3
import com.example.dcache.biz.tutorial.Tutorial
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
                .tables(Tutorial::class.java,
                    TestCaseModel::class.java,
                    TestCaseModel2::class.java,
                    TestCaseModel3::class.java)
                .version(1)
                .build())
    }
}