package com.example.doracachesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dora.db.OrmTable
import dora.db.builder.QueryBuilder
import dora.db.dao.DaoFactory
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
                    "D"+generateAccKey(), "P"+generateAccKey()))
//            DaoFactory.getDao(Account::class.java).update(Account("这个是key",
//                    "D"+generateAccKey(), "P"+generateAccKey()))
        }
        btnAccRefresh.setOnClickListener {
            refreshAccounts(adapter)
        }
        btnAccRemove.setOnClickListener {
            val selectOne = DaoFactory.getDao(Account::class.java)
                    .selectOne(QueryBuilder.create().orderBy(OrmTable.INDEX_ID))
            if (selectOne != null) {
                DaoFactory.getDao(Account::class.java).delete(selectOne)
            }
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        refreshAccounts(adapter)
    }

    private fun generateAccKey() : String {
        return UUID.randomUUID().toString()
    }

    private fun refreshAccounts(adapter: AccountAdapter) {
//        val count = DaoFactory.getDao(Account::class.java).selectCount()
        val accounts = DaoFactory.getDao(Account::class.java).selectAll()
        adapter.setAccounts(accounts)
    }
}