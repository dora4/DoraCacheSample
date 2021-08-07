package com.example.doracachesample.biz.weather

import android.content.Context
import android.content.res.AssetManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.doracachesample.R
import dora.http.DoraHttp.net
import dora.http.DoraHttp.request
import dora.http.log.FormatLogInterceptor
import dora.http.retrofit.DoraRetrofitManager
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
        readAssetsText(adapter, this, "adcode_test.csv")
    }

    @Throws(IOException::class)
    fun readAssetsText(adapter: TemperatureAdapter, context: Context, fileName: String) {
        val assetManager: AssetManager = context.assets
        val bf = BufferedReader(InputStreamReader(assetManager.open(fileName)))
        var line: String? = ""
        while (bf.readLine().also { line = it } != null) {
            val value = line?.split(",")
            value?.let {
                loopAddItem(adapter, "${it[1]},${it[2]}", it[6])
            }
        }
    }

    private fun loopAddItem(adapter: TemperatureAdapter, latlng: String, addr: String) {
        repository.latlng = latlng
        repository.fetchListData().observe(this, Observer {
            adapter.addTemperatures(it)
        })
    }
}