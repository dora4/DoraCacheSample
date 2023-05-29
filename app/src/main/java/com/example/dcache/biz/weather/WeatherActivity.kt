package com.example.dcache.biz.weather

import android.content.Context
import android.content.res.AssetManager
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dcache.R
import dora.cache.data.fetcher.OnLoadStateListener
import dora.http.DoraHttp.net
import dora.http.DoraHttp.request
import dora.http.log.FormatLogInterceptor
import dora.http.retrofit.RetrofitManager
import java.io.*

/**
 * 综合案例，演示一个天气预报功能，即使断网后也能再加载历史数据。
 */
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
                // 添加一个格式化日志输出的拦截器
                interceptors().add(FormatLogInterceptor())
                build()
            }
            // mappingBaseUrl取代了过时的registerBaseUrl，方便更换域名
            mappingBaseUrl(
                WeatherService::class.java,
                "https://api.caiyunapp.com/v2.5/Pezyxsyn6yccBaZd/"
            )
        }
        repository.getListLiveData().observe(this, Observer {
            adapter.setTemperatures(it)
        })
        // 开辟一个net作用域来执行协程
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
            value?.let { data ->
                request {
                    Thread(Runnable {
                        repository.latlng = "${data[1]},${data[2]}"
                        repository.addr = data[6]
                        // 边加载和显示数据，边缓存数据到数据库，它的数据在onCreate的以下中代码被观察
                        // repository.getListLiveData().observe(this, Observer {
                        //    adapter.setTemperatures(it)
                        // })
                        repository.fetchListData(listener = object : OnLoadStateListener {
                            override fun onLoad(state: Int) {
                                Log.d("WeatherActivity", "数据是否加载成功：${state==0}")
                                // 无论成功与失败，3秒后播报下一个城市
                                SystemClock.sleep(3000)
                                // 解除阻塞
                                it.releaseLock(null)
                            }
                        }, description = null)
                    }).start()
                }
            }
        }
    }
}