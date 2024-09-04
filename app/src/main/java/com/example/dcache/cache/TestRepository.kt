package com.example.dcache.cache

import android.content.Context
import com.example.dcache.http.ApiResult
import com.example.dcache.http.PageDTO
import com.example.dcache.http.TestService
import com.example.dcache.orm.TestCaseModel4
import dora.cache.DoraPageListCallback
import dora.cache.data.adapter.PageListResultAdapter
import dora.cache.data.fetcher.OnLoadStateListener
import dora.cache.factory.DatabaseCacheHolderFactory
import dora.cache.repository.DoraPageDatabaseCacheRepository
import dora.cache.repository.ListRepository
import dora.http.retrofit.RetrofitManager
import retrofit2.Callback

@ListRepository
class TestRepository(context: Context) : DoraPageDatabaseCacheRepository<TestCaseModel4>(context) {

    override fun createCacheHolderFactory(): DatabaseCacheHolderFactory<TestCaseModel4> {
        return DatabaseCacheHolderFactory(TestCaseModel4::class.java)
    }

    override fun onLoadFromNetwork(
        callback: DoraPageListCallback<TestCaseModel4>,
        listener: OnLoadStateListener?
    ) {
        RetrofitManager.getService(TestService::class.java).sendPostPageTest(getPageSize(), getPageNo())
            .enqueue(PageListResultAdapter<TestCaseModel4, ApiResult<TestCaseModel4>>(callback)
                    as Callback<ApiResult<PageDTO<TestCaseModel4>>>)
    }
}