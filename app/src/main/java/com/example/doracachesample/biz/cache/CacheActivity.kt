package com.example.doracachesample.biz.cache

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.doracachesample.R
import com.example.doracachesample.biz.weather.WeatherService
import com.example.doracachesample.repository.*
import dora.http.log.FormatLogInterceptor
import dora.http.retrofit.DoraRetrofitManager

class CacheActivity : AppCompatActivity() {

    lateinit var weatherRepository: WeatherRepository
    lateinit var realTimeRepository: RealTimeRepository
    lateinit var minutelyRepository: MinutelyRepository
    lateinit var hourlyRepository: HourlyRepository
    lateinit var dailyRepository: DailyRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cache)
        weatherRepository = WeatherRepository(this)
        realTimeRepository = RealTimeRepository(this)
        minutelyRepository = MinutelyRepository(this)
        hourlyRepository = HourlyRepository(this)
        dailyRepository = DailyRepository(this)
        val tvMemoryCache = findViewById<TextView>(R.id.tvMemoryCache)
        val tvCacheRealtime = findViewById<TextView>(R.id.tvCacheRealtime)
        val tvCacheMinutely = findViewById<TextView>(R.id.tvCacheMinutely)
        val tvCacheHourly = findViewById<TextView>(R.id.tvCacheHourly)
        val tvCacheDaily = findViewById<TextView>(R.id.tvCacheDaily)
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
        // 内存缓存
        weatherRepository.latlng = "116.407526,39.90403"
        weatherRepository.fetchData().observe(this, Observer {
            it?.apply {
                tvMemoryCache.text = "weather:${toString()}\n\n"
            }
        })
        // 数据库缓存
        realTimeRepository.latlng = "116.407526,39.90403"
        realTimeRepository.fetchData().observe(this, Observer {
            it?.apply {
                tvCacheRealtime.text = "realtime:${toString()}\n\n"
            }
        })
        minutelyRepository.latlng = "116.407526,39.90403"
        minutelyRepository.fetchData().observe(this, Observer {
            it?.apply {
                tvCacheMinutely.text = "minutely:${toString()}\n\n"
            }
        })
        hourlyRepository.latlng = "116.407526,39.90403"
        hourlyRepository.fetchData().observe(this, Observer {
            it?.apply {
                tvCacheHourly.text = "hourly:${toString()}\n\n"
            }
        })
        dailyRepository.latlng = "116.407526,39.90403"
        dailyRepository.fetchData().observe(this, Observer {
            it?.apply {
                tvCacheDaily.text = "daily:${toString()}\n\n"
            }
        })
    }
}