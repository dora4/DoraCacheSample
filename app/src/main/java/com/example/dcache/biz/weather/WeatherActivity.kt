package com.example.dcache.biz.weather

import android.content.Context
import android.content.res.AssetManager
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dcache.R
import dora.http.DoraHttp.net
import dora.http.DoraHttp.request
import dora.http.log.FormatLogInterceptor
import dora.http.retrofit.RetrofitManager
import java.io.*

class WeatherActivity : AppCompatActivity() {

    lateinit var repository: TemperatureRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        repository = TemperatureRepository(this)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 5)
        val adapter = TemperatureAdapter()
        recyclerView.adapter = adapter
        RetrofitManager.initConfig {
            okhttp {
                interceptors().add(FormatLogInterceptor())
                build()
            }
            registerBaseUrl(
                WeatherService::class.java,
                "https://api.caiyunapp.com/v2.5/Pezyxsyn6yccBaZd/"
            )
        }
        // 主线程
        repository.getListLiveData().observe(this, Observer {
            adapter.setTemperatures(it)
        })
        net {
            readAssetsText(this, "adcode_test.csv")
        }
    }

    @Throws(IOException::class)
    suspend fun readAssetsText(context: Context, fileName: String) {
        val assetManager: AssetManager = context.assets
        val bf = BufferedReader(InputStreamReader(assetManager.open(fileName)))
        var line: String? = ""
        while (bf.readLine().also { line = it } != null) {
            val value = line?.split(",")
            value?.let {
                request {
                    // 子线程
                    repository.latlng = "${it[1]},${it[2]}"
                    repository.addr = it[6]
                    repository.fetchListData()
                    Thread.sleep(3000)
                }
            }
        }
    }
}