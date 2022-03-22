package com.example.dcache.biz.cache

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.dcache.R
import com.example.dcache.biz.weather.WeatherService
import com.example.dcache.repository.*
import dora.http.log.FormatLogInterceptor
import dora.http.retrofit.RetrofitManager

class CacheActivity : AppCompatActivity() {

//    lateinit var weatherRepository: WeatherRepository
//    lateinit var realTimeRepository: RealTimeRepository
    lateinit var minutelyRepository: MinutelyRepository
//    lateinit var hourlyRepository: HourlyRepository
//    lateinit var dailyRepository: DailyRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cache)
//        weatherRepository = WeatherRepository(this)
//        realTimeRepository = RealTimeRepository(this)
        minutelyRepository = MinutelyRepository(this)
//        hourlyRepository = HourlyRepository(this)
//        dailyRepository = DailyRepository(this)
        val tvMemoryCache = findViewById<TextView>(R.id.tvMemoryCache)
        val tvCacheRealtime = findViewById<TextView>(R.id.tvCacheRealtime)
        val tvCacheMinutely = findViewById<TextView>(R.id.tvCacheMinutely)
        val tvCacheHourly = findViewById<TextView>(R.id.tvCacheHourly)
        val tvCacheDaily = findViewById<TextView>(R.id.tvCacheDaily)
        RetrofitManager.init {
            okhttp {
                interceptors().add(FormatLogInterceptor())
                this
            }
            registerBaseUrl(
                    WeatherService::class.java,
                    "https://api.caiyunapp.com/v2.5/Pezyxsyn6yccBaZd/"
            )
        }
//        // 内存缓存
//        weatherRepository.latlng = "116.407526,39.90403"
//        weatherRepository.fetchData().observe(this, Observer {
//            it?.apply {
//                tvMemoryCache.text = "weather:${toString()}\n"
//            }
//        })
//        // 数据库缓存
//        realTimeRepository.latlng = "116.407526,39.90403"
//        realTimeRepository.fetchData().observe(this, Observer {
//            it?.apply {
//                tvCacheRealtime.text = "realtime:${toString()}\n"
//            }
//        })
        minutelyRepository.latlng = "116.407526,39.90403"
        minutelyRepository.fetchData().observe(this, Observer {
            it?.apply {
                tvCacheMinutely.text = "minutely:${toString()}\n"
            }
        })
//        hourlyRepository.latlng = "116.407526,39.90403"
//        hourlyRepository.fetchData().observe(this, Observer {
//            it?.apply {
//                tvCacheHourly.text = "hourly:${toString()}\n"
//            }
//        })
//        dailyRepository.latlng = "116.407526,39.90403"
//        dailyRepository.fetchData().observe(this, Observer {
//            it?.apply {
//                tvCacheDaily.text = "daily:${toString()}\n"
//            }
//        })
    }
}