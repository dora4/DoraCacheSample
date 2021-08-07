package com.example.doracachesample.biz.cover

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.doracachesample.biz.orm.AccountActivity
import com.example.doracachesample.R
import com.example.doracachesample.biz.cache.CacheActivity
import com.example.doracachesample.biz.http.PachongActivity
import com.example.doracachesample.biz.weather.WeatherActivity

/**
 * 封面。
 */
class CoverActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cover)
        val rvCover = findViewById<RecyclerView>(R.id.rvCover)
        rvCover.layoutManager = GridLayoutManager(this, 2)
        val covers = arrayListOf(
                CoverModel("网络爬虫测试", R.drawable.icon_pachong),
                CoverModel("数据保存测试", R.drawable.icon_data),
                CoverModel("数据缓存测试", R.drawable.icon_cache),
                CoverModel("天气案例", R.drawable.icon_weather)
        )
        val adapter = CoverAdapter(covers)
        adapter.onItemClick { pos, model ->
            when(pos) {
                0 -> {
                    startActivity(Intent(this, PachongActivity::class.java))
                }
                1 -> {
                    startActivity(Intent(this, AccountActivity::class.java))
                }
                2 -> {
                    startActivity(Intent(this, CacheActivity::class.java))
                }
                3 -> {
                    startActivity(Intent(this, WeatherActivity::class.java))
                }
            }
        }
        rvCover.adapter = adapter
    }
}