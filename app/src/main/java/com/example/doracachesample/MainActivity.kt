package com.example.doracachesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.doracachesample.httpresult.TestService
import dora.db.OrmTable
import dora.db.Transaction
import dora.db.builder.QueryBuilder
import dora.db.dao.DaoFactory
import dora.http.DoraHttp.api
import dora.http.DoraHttp.net
import dora.http.DoraHttp.result
import dora.http.DoraHttpException
import dora.http.retrofit.DoraRetrofitManager
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val btnAccAdd = findViewById<Button>(R.id.btnAccAdd)
        val btnAccRefresh = findViewById<Button>(R.id.btnAccRefresh)
        val btnAccRemove = findViewById<Button>(R.id.btnAccRemove)
        val adapter = AccountAdapter()
        btnAccAdd.setOnClickListener {
            DaoFactory.getDao(Account::class.java).insert(Account(generateAccKey(),
                    "D" + generateAccKey(), "P" + generateAccKey()))
//            DaoFactory.getDao(Account::class.java).update(Account("这个是key",
//                    "D"+generateAccKey(), "P"+generateAccKey()))

        }
        btnAccRefresh.setOnClickListener {
            refreshAccounts(adapter)
        }
        btnAccRemove.setOnClickListener {
            Transaction.execute(Account::class.java) {
                val selectOne = it.selectOne(QueryBuilder.create().orderBy(OrmTable.INDEX_ID))
                if (selectOne != null) {
                    it.delete(selectOne)
                }
            }
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        refreshAccounts(adapter)
    }

    private fun generateAccKey(): String {
        return UUID.randomUUID().toString()
    }

    private fun refreshAccounts(adapter: AccountAdapter) {
//        val count = DaoFactory.getDao(Account::class.java).selectCount()
        val accounts = DaoFactory.getDao(Account::class.java).selectAll()
        adapter.setAccounts(accounts)
        DoraRetrofitManager.registerBaseUrl(TestService::class.java, "http://api.k780.com")
        net {
            val testRequest = try {
                api {
                    DoraRetrofitManager
                            .getService(TestService::class.java).testRequest()
                }
            } catch (e: DoraHttpException) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
            }
            val testRequest2 = api {
                DoraRetrofitManager
                        .getService(TestService::class.java).testRequest()
            }
            val testRequest3 = result {
                DoraRetrofitManager
                        .getService(TestService::class.java).testRequest()
            }
            Toast.makeText(this, "$testRequest--$testRequest2--$testRequest3", Toast.LENGTH_SHORT).show()
        }
//        DoraRetrofitManager.registerBaseUrl(AccountService::class.java, "http://github.com/dora4/")
//        DoraRetrofitManager.client.authenticator
//        DoraRetrofitManager.client.cookieJar
//        DoraRetrofitManager.client.interceptors
//        DoraRetrofitManager.client.networkInterceptors

//        // 方式一：并行请求，直接调用即可
//        DoraRetrofitManager.getService(AccountService::class.java).getAccount()
//                .enqueue(object : DoraCallback<Account>() {
//
//                    override fun onFailure(code: Int, msg: String?) {
//                    }
//
//                    override fun onSuccess(data: Account) {
//                    }
//                })
//        // 方式二：串行请求，在net作用域内的api请求，可以很方便的进行数据的合并处理，推荐使用
//        net {
//            val account1 = api {
//                DoraRetrofitManager.getService(AccountService::class.java).getAccount()
//            }
//            val account2 = api {
//                DoraRetrofitManager.getService(AccountService::class.java).getAccount()
//            }
//        }
    }
}