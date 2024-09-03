package com.example.dcache.biz.cover

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dcache.biz.orm.OrmTestCasesActivity
import com.example.dcache.R
import com.example.dcache.biz.cache.CacheActivity
import com.example.dcache.biz.http.CrawlerActivity
import com.example.dcache.biz.tutorial.TutorialActivity

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
                CoverModel(getString(R.string.cover_sunshine), R.drawable.icon_sun),
                CoverModel("数据保存测试", R.drawable.icon_storage),
                CoverModel("网络爬虫测试", R.drawable.icon_crawler),
                CoverModel("数据缓存测试", R.drawable.icon_bucket)
        )
        val adapter = CoverAdapter(covers)
        adapter.onItemClick { pos, model ->
            when(pos) {
                0 -> {
                    startActivity(Intent(this, TutorialActivity::class.java))
                }
                1 -> {
                    startActivity(Intent(this, OrmTestCasesActivity::class.java))
                }
                2 -> {
                    startActivity(Intent(this, CrawlerActivity::class.java))
                }
                3 -> {
//                    startActivity(Intent(this, CacheActivity::class.java))
                }
            }
        }
        rvCover.adapter = adapter
    }
}