package com.example.dcache.biz.http

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.dcache.R
import com.example.dcache.biz.orm.TestCaseModel
import dora.http.DoraHttp.net
import dora.http.DoraHttp.result
import dora.http.retrofit.RetrofitManager
import java.io.IOException

class CrawlerActivity : AppCompatActivity() {

    private var isRunning: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crawler)
        val ivRun = findViewById<ImageView>(R.id.iv_run)
        val tvPrint = findViewById<TextView>(R.id.tv_print)
        ivRun.setOnClickListener {
            if (!isRunning) {
                net {
                    ivRun.visibility = View.GONE
                    isRunning = true
                    for (i in 0 until 100) {
                        val models = result {
                            RetrofitManager.getService(TestService::class.java).sendGetTest(10)
                        }?.data
                        loopPrint(tvPrint, this@CrawlerActivity, models)
                    }
                    ivRun.visibility = View.VISIBLE
                    isRunning = false
                }
            } else {
                Toast.makeText(this, "正在跑呢", Toast.LENGTH_SHORT).show()
            }
        }
    }

    @Throws(IOException::class)
    fun loopPrint(tvPrint: TextView, context: Context, models: MutableList<TestCaseModel>?) {
        tvPrint.text = ""
        models?.forEach {
            printLine(tvPrint, it)
        }
    }

    private fun printLine(tvPrint: TextView, model: TestCaseModel?) {
        if (model != null) {
            tvPrint.append("${model.booleanVal},${model.shortVal},${model.intVal}," +
                    "${model.longVal},${model.floatVal},${model.doubleVal}\n")
        } else {
            tvPrint.append("null\n")
        }
        val scrollView = findViewById<ScrollView>(R.id.scrollView)
        scrollView.scrollTo(0, tvPrint.height)
    }
}