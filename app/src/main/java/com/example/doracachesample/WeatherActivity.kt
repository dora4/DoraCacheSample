package com.example.doracachesample

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.doracachesample.realtime.RealTimeModel
import dora.http.DoraHttp.net
import dora.http.DoraHttp.request
import dora.http.DoraHttp.result
import dora.http.retrofit.DoraRetrofitManager

class WeatherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        val tvWeather = findViewById<TextView>(R.id.tv_weather)
        // https://api.caiyunapp.com/v2.5/Pezyxsyn6yccBaZd/121.6544,25.1552/weather.json
        DoraRetrofitManager.init {
            registerBaseUrl(WeatherService::class.java,
                    "https://api.caiyunapp.com/v2.5/Pezyxsyn6yccBaZd/121.6544,25.1552/")
        }
        net {
            val weather = result {
                DoraRetrofitManager.getService(WeatherService::class.java).getWeather()
            }
            request {
                val repository =
                        RealTimeRepository(this)
                repository.fetchData().observe(this,
                        Observer<RealTimeModel> { model ->
                            model?.let {
                                tvWeather.text = "天气：$weather\n实时：$it\n"
                            }
                        })
            }
        }
    }
}