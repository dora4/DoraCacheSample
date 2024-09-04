package com.example.dcache.http

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.dcache.R
import com.example.dcache.orm.TestCaseModel2
import dora.http.DoraHttp.net
import dora.http.DoraHttp.result
import dora.http.retrofit.RetrofitManager

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
                    val start = System.currentTimeMillis()
                    for (i in 0 until 10) {
                        val models = result {
                            RetrofitManager.getService(TestService::class.java).sendGetTest(10)
                        }?.data
                        loopPrint(tvPrint, models)
                    }
                    ivRun.visibility = View.VISIBLE
                    val end = System.currentTimeMillis()
                    val time = end - start
                    tvPrint.text = "API调用测试完成，共耗时${time}ms"
                    isRunning = false
                }
            } else {
                Toast.makeText(this, "正在跑呢", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loopPrint(tvPrint: TextView, models: MutableList<TestCaseModel2>?) {
        tvPrint.text = "10次API调用测试\n\n"
        models?.forEach {
            printLine(tvPrint, it)
        }
    }

    private fun printLine(tvPrint: TextView, model: TestCaseModel2?) {
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