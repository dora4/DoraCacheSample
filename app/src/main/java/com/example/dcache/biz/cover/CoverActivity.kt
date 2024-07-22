package com.example.dcache.biz.cover

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dcache.biz.orm.OrmTestCaseActivity
import com.example.dcache.R
import com.example.dcache.biz.cache.CacheActivity
import com.example.dcache.biz.http.CrawlerActivity
import com.example.dcache.biz.weather.WeatherActivity

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
                CoverModel("网络爬虫测试", R.drawable.icon_crawler),
                CoverModel("数据保存测试", R.drawable.icon_storage),
                CoverModel("数据缓存测试", R.drawable.icon_bucket),
                CoverModel("天气案例", R.drawable.icon_weather)
        )
        val adapter = CoverAdapter(covers)
        adapter.onItemClick { pos, model ->
            when(pos) {
                0 -> {
                    startActivity(Intent(this, CrawlerActivity::class.java))
                }
                1 -> {
                    startActivity(Intent(this, OrmTestCaseActivity::class.java))
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