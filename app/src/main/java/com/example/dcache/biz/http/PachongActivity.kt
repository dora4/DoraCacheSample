package com.example.dcache.biz.http

import android.content.Context
import android.content.res.AssetManager
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.dcache.R
import com.example.dcache.biz.weather.WeatherService
import com.example.dcache.model.DailyModel
import com.example.dcache.model.HourlyModel
import dora.http.DoraHttp
import dora.http.DoraHttp.net
import dora.http.log.FormatLogInterceptor
import dora.http.retrofit.DoraRetrofitManager
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class PachongActivity : AppCompatActivity() {

    private var isRunning: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pachong)
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
        DoraRetrofitManager.init {
            okhttp {
                interceptors().add(FormatLogInterceptor())
                this
            }
            registerBaseUrl(
                    WeatherService::class.java,
                    "https://api.caiyunapp.com/v2.5/Pezyxsyn6yccBaZd/"
            )
        }
    }

    @Throws(IOException::class)
    suspend fun readAssetsText(tvPrint: TextView, context: Context, fileName: String) {
        tvPrint.text = ""
        val assetManager: AssetManager = context.assets
        val bf = BufferedReader(InputStreamReader(assetManager.open(fileName)))
        var line: String? = ""
        while (bf.readLine().also { line = it } != null) {
            val value = line?.split(",")
            value?.let {
                loopPrint(tvPrint, "${it[1]},${it[2]}", it[6])
            }
        }
    }

    private suspend fun loopPrint(tvPrint: TextView, latlng: String, addr: String) {
        val ret = DoraHttp.result {
            DoraRetrofitManager.getService(WeatherService::class.java)
                    .getDaily(latlng)
        }
        printLine(tvPrint, addr, ret)
    }

    private fun printLine(tvPrint: TextView, addr: String, model: DailyModel?) {
        if (model != null) {
            tvPrint.append("$addr:${model!!.result!!.daily!!.temperature!![0]!!.min.toInt()}°/${model!!
                    .result!!.daily!!.temperature!![0]!!.max.toInt()}°\n")
        } else {
            tvPrint.append("$addr:null\n")
        }
        val scrollView = findViewById<ScrollView>(R.id.scrollView)
        scrollView.scrollTo(0, tvPrint.height)
    }
}