package com.example.doracachesample.biz.http

import android.content.Context
import android.content.res.AssetManager
import android.os.Bundle
import android.widget.Button
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.doracachesample.R
import com.example.doracachesample.biz.weather.WeatherService
import com.example.doracachesample.model.DailyModel
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
        val btnGo = findViewById<Button>(R.id.btn_go)
        val tvPrint = findViewById<TextView>(R.id.tv_print)
        btnGo.setOnClickListener {
            if (!isRunning) {
                net {
                    isRunning = true
                    readAssetsText(tvPrint, this, "adcode_test.csv")
                        isRunning = false
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
        Thread.sleep(40)
        if (model != null) {
            tvPrint.append("$addr:${model!!.result!!.daily!!.temperature!![0]!!.min}°/${model!!
                    .result!!.daily!!.temperature!![0]!!.max}°\n")
        } else {
            tvPrint.append("$addr:null\n")
        }
        val scrollView = findViewById<ScrollView>(R.id.scrollView)
        scrollView.scrollTo(0, tvPrint.height)
    }
}