package com.example.dcache.cache

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.dcache.R
import com.example.dcache.orm.TestCaseModel4
import dora.cache.repository.DoraPageDatabaseCacheRepository
import dora.db.dao.DaoFactory
import dora.util.ViewUtils
import dora.widget.DoraEmptyLayout
import dora.widget.pull.SwipeLayout

class CacheActivity : AppCompatActivity() {

    private lateinit var repository: TestRepository
    private val adapter = TestCaseModelAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cache)
        repository = TestRepository(this)
        val tvStart = findViewById<TextView>(R.id.tvStart)
        val tvReset = findViewById<TextView>(R.id.tvReset)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val emptyLayout = findViewById<DoraEmptyLayout>(R.id.emptyLayout)
        val swipeLayout = findViewById<SwipeLayout>(R.id.swipeLayout)
        tvStart.setOnClickListener {
            repository.onRefresh()
        }
        tvReset.setOnClickListener {
            DaoFactory.getDao(TestCaseModel4::class.java).deleteAll()
            adapter.setList(null)
            emptyLayout.showEmpty()
        }
        ViewUtils.configRecyclerView(recyclerView).adapter = adapter
        repository.observeData(this, object : DoraPageDatabaseCacheRepository.AdapterDelegate<TestCaseModel4> {

            override fun addData(data: MutableList<TestCaseModel4>) {
                adapter.addData(data)
                emptyLayout.showContent()
            }

            override fun setList(data: MutableList<TestCaseModel4>) {
                adapter.setList(data)
                emptyLayout.showContent()
            }
        })
        swipeLayout.setOnSwipeListener(object : SwipeLayout.OnSwipeListener {

            override fun onRefresh(swipeLayout: SwipeLayout) {
            }

            override fun onLoadMore(swipeLayout: SwipeLayout) {
                repository.onLoadMore {
                    swipeLayout.loadMoreFinish(if (it) SwipeLayout.SUCCEED else SwipeLayout.FAIL)
                }
            }
        })
        if (DaoFactory.getDao(TestCaseModel4::class.java).count() > 0) {
            adapter.setList(DaoFactory.getDao(TestCaseModel4::class.java).selectAll())
            emptyLayout.showContent()
        }
    }
}