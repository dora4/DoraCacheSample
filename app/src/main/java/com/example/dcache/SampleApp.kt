package com.example.dcache

import android.app.Application
import com.example.dcache.http.TestService
import com.example.dcache.orm.TestCaseModel
import com.example.dcache.orm.TestCaseModel2
import com.example.dcache.orm.TestCaseModel3
import com.example.dcache.orm.TestCaseModel4
import com.example.dcache.tutorial.Tutorial
import dora.db.Orm
import dora.db.OrmConfig
import dora.http.retrofit.RetrofitManager
import java.util.concurrent.TimeUnit

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
                    TestCaseModel3::class.java,
                    TestCaseModel4::class.java)
                .version(2)
                .build())
        RetrofitManager.initConfig {
            okhttp {
                connectTimeout(3, TimeUnit.SECONDS)
                readTimeout(10, TimeUnit.SECONDS)
                build()
            }
            mappingBaseUrl(TestService::class.java, "http://dorachat.com:9091/")
        }
    }
}