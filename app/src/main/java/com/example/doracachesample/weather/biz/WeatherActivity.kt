package com.example.doracachesample.weather.biz

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.doracachesample.R
import com.example.doracachesample.weather.common.Temperature
import com.example.doracachesample.weather.daily.DailyModel
import dora.http.DoraHttp.net
import dora.http.DoraHttp.request
import dora.http.log.FormatLogInterceptor
import dora.http.retrofit.DoraRetrofitManager

class WeatherActivity : AppCompatActivity() {

    lateinit var weatherRepository: WeatherRepository
    lateinit var realTimeRepository: RealTimeRepository
    lateinit var dailyRepository: DailyRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        weatherRepository = WeatherRepository(this)
        realTimeRepository = RealTimeRepository(this)
        dailyRepository = DailyRepository(this)

        val btnRefresh = findViewById<Button>(R.id.btn_refresh)
        val rvWeather = findViewById<RecyclerView>(R.id.rv_weather)
        btnRefresh.setOnClickListener {
            refresh(rvWeather)
        }
        rvWeather.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        DoraRetrofitManager.init {
            okhttp {
                interceptors().add(FormatLogInterceptor())
                this
            }
            registerBaseUrl(WeatherService::class.java,
                    "https://api.caiyunapp.com/v2.5/Pezyxsyn6yccBaZd/121.6544,25.1552/")
        }
        refresh(rvWeather)
    }

    private fun refresh(recyclerView: RecyclerView) {
        net {
            request {
                dailyRepository.fetchData().observe(this, Observer<DailyModel> {
                    it?.let {
                        if (it.api_status == "active") {
                            it.result?.apply {
                                daily.temperature.apply {
                                    recyclerView.adapter = WeatherAdapter(this as ArrayList<Temperature>)
                                }
                            }
                        }
                    }
                })
            }
        }
    }
}