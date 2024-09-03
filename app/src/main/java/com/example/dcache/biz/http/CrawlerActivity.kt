package com.example.dcache.biz.http

import android.content.Context
import android.content.res.AssetManager
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.dcache.R
import dora.http.DoraHttp.net
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class CrawlerActivity : AppCompatActivity() {

    private var isRunning: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crawler)
        val ivRun = findViewById<ImageView>(R.id.iv_run)
        val tvPrint = findViewById<TextView>(R.id.tv_print)
        ivRun.setOnClickListener {
            if (!isRunning) {
                net {
                    ivRun.visibility = View.GONE
                    isRunning = true
                    readAssetsText(tvPrint, this, "adcode_test.csv")
                    isRunning = false
                    ivRun.visibility = View.VISIBLE
                }
            } else {
                Toast.makeText(this, "正在跑呢", Toast.LENGTH_SHORT).show()
            }
        }
//        RetrofitManager.initConfig {
//            builder.interceptors().add(FormatLogInterceptor())
//            setClient(builder.build())
//            mappingBaseUrl(
//                    WeatherService::class.java,
//                    "https://api.caiyunapp.com/v2.5/Pezyxsyn6yccBaZd/"
//            )
//        }
    }

    @Throws(IOException::class)
    suspend fun readAssetsText(tvPrint: TextView, context: Context, fileName: String) {
        tvPrint.text = ""
        val assetManager: AssetManager = context.assets
        val bf = BufferedReader(InputStreamReader(assetManager.open(fileName)))
        var line: String? = ""
        while (withContext(Dispatchers.IO) {
                bf.readLine()
            }.also { line = it } != null) {
            val value = line?.split(",")
            value?.let {
                loopPrint(tvPrint, "${it[1]},${it[2]}", it[6])
            }
        }
    }

    private suspend fun loopPrint(tvPrint: TextView, latlng: String, addr: String) {
//        val ret = result {
//            RetrofitManager.getService(WeatherService::class.java)
//                    .getDaily(latlng)
//        }
//        printLine(tvPrint, addr, ret)
    }
}