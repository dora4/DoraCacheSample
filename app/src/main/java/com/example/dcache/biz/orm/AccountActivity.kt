package com.example.dcache.biz.orm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dcache.R
import dora.db.Transaction
import dora.db.builder.QueryBuilder
import dora.db.dao.DaoFactory
import dora.db.table.OrmTable
import dora.http.log.FormatLogInterceptor
import dora.http.retrofit.RetrofitManager
import okhttp3.Authenticator
import okhttp3.CookieJar
import java.util.*

class AccountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val ivAccAdd = findViewById<ImageView>(R.id.ivAccAdd)
        val ivAccRefresh = findViewById<ImageView>(R.id.ivAccRefresh)
        val ivAccRemove = findViewById<ImageView>(R.id.ivAccRemove)
        val adapter = AccountAdapter()
//        val repository = AccountRepository(this)
//        repository.fetchListData().observe(this,
//            Observer<List<Account>> {
//
//            })
//        repository.obtainPager()
//        .setPageCallback(object : PageCallback<Account> {
//            override fun onResult(models: List<Account>) {
//            }
//        })
//        .accept(DefaultPageDataVisitor<Account>())
        ivAccAdd.setOnClickListener {
            DaoFactory.getDao(Account::class.java)
                .insert(Account(generateAccKey(),
                    "D" + generateAccKey(), "P" + generateAccKey()))
//            DaoFactory.getDao(Account::class.java).update(Account("这个是key",
//                    "D"+generateAccKey(), "P"+generateAccKey()))

        }
        ivAccRefresh.setOnClickListener {
            refreshAccounts(adapter)
        }
        ivAccRemove.setOnClickListener {
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
        RetrofitManager.initConfig {
            okhttp {
                authenticator(Authenticator.NONE)
                cookieJar(CookieJar.NO_COOKIES)
                networkInterceptors().add(FormatLogInterceptor())
                build()
            }
//            registerBaseUrl(TestService::class.java, "http://api.k780.com")
            mappingBaseUrl(AccountService::class.java, "http://github.com/dora4")
        }
//        net {
//            val testRequest = try {
//                api {
//                    DoraRetrofitManager
//                            .getService(TestService::class.java).testRequest()
//                }
//            } catch (e: DoraHttpException) {
//                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
//            }
//            val testRequest2 = api {
//                DoraRetrofitManager
//                        .getService(TestService::class.java).testRequest()
//            }
//            val testRequest3 = result {
//                DoraRetrofitManager
//                        .getService(TestService::class.java).testRequest()
//            }
//            Toast.makeText(this, "$testRequest--$testRequest2--$testRequest3", Toast.LENGTH_SHORT).show()
//        }
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