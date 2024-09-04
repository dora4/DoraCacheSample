package com.example.dcache.orm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.dcache.R
import dora.db.builder.WhereBuilder
import dora.db.dao.DaoFactory
import dora.http.DoraHttp
import dora.http.DoraHttp.net
import kotlin.random.Random

class OrmReadTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orm_read_test)
        net {
            writeObjects()
            readObjects()
            DaoFactory.getDao(TestCaseModel2::class.java).deleteAll()
        }
    }

    private fun getRandomObject(): TestCaseModel2 {
        val model = TestCaseModel2()
        model.booleanVal = Random.nextBoolean()
        model.shortVal = (Random.nextInt(65535) - 32767).toShort()
        model.intVal = Random.nextInt()
        model.longVal = Random.nextLong()
        model.floatVal = Random.nextFloat()
        model.doubleVal = Random.nextDouble()
        return model
    }

    private suspend fun writeObjects() {
        val tvOrmReadResult = findViewById<TextView>(R.id.tvOrmReadResult)
        tvOrmReadResult.text = "正在准备数据"
        val time = DoraHttp.request {
            Thread(Runnable {
                val start = System.currentTimeMillis()
                for (i in 0 until 10000) {
                    val model = getRandomObject()
                    model.index = i
                    DaoFactory.getDao(TestCaseModel2::class.java).insert(model)
                    runOnUiThread {
                        tvOrmReadResult.text = "正在准备第${i + 1}条数据，${model.toString()}"
                    }
                }
                val end = System.currentTimeMillis()
                it.releaseLock(end - start)
            }).start()
        }
        tvOrmReadResult.text = "数据准备完成"
    }

    private suspend fun readObjects() {
        val tvOrmReadResult = findViewById<TextView>(R.id.tvOrmReadResult)
        tvOrmReadResult.text = "开始执行读取数据操作"
        val time = DoraHttp.request {
            Thread(Runnable {
                val start = System.currentTimeMillis()
                for (i in 0 until 10000) {
                    val model = DaoFactory.getDao(TestCaseModel2::class.java).selectOne(
                        WhereBuilder.create().addWhereEqualTo(
                            "data_index", i))
                    runOnUiThread {
                        tvOrmReadResult.text = "正在读取第${i + 1}条数据，${model.toString()}"
                    }
                }
                val end = System.currentTimeMillis()
                it.releaseLock(end - start)
            }).start()
        }
        tvOrmReadResult.text = "数据读取测试完成，共耗时${time}ms"
    }
}