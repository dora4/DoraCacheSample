package com.example.doracachesample

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import dora.http.DoraHttp.api
import dora.http.DoraHttp.net
import dora.http.DoraHttpException
import dora.http.retrofit.DoraRetrofitManager

class WeatherActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        val tvWeather = findViewById<TextView>(R.id.tv_weather)
        DoraRetrofitManager.init {
            registerBaseUrl(WeatherService::class.java,
                    "https://api.caiyunapp.com/v2.5/Pezyxsyn6yccBaZd/121.6544,25.1552")
        }
        net {
            val weather = try {
                api {
                    DoraRetrofitManager.getService(WeatherService::class.java).getWeather()
                }
            } catch (e: DoraHttpException) {
                tvWeather.text = e.toString()
            }
            val realTime = api {
                DoraRetrofitManager.getService(WeatherService::class.java).getRealTime()
            }
            tvWeather.text = "天气：$weather\n实时：$realTime"
        }
    }
}