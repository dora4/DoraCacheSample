package com.example.dcache.biz.http

import com.example.dcache.biz.ApiResult
import com.example.dcache.biz.PageDTO
import com.example.dcache.biz.orm.TestCaseModel
import dora.http.retrofit.ApiService
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface TestService : ApiService {

    @POST("openApi/test")
    @FormUrlEncoded
    fun sendPostTest(@Field("pageSize") pageSize: Int): Call<ApiResult<MutableList<TestCaseModel>>>

    @GET("openApi/test")
    fun sendGetTest(@Query("pageSize") pageSize: Int): Call<ApiResult<MutableList<TestCaseModel>>>

    @POST("openApi/pageTest")
    @FormUrlEncoded
    fun sendPostPageTest(@Field("pageSize") pageSize: Int, @Field("pageNo") pageNo: Int): Call<ApiResult<PageDTO<TestCaseModel>>>

    @GET("openApi/pageTest")
    fun sendGetPageTest(@Query("pageSize") pageSize: Int, @Query("pageNo") pageNo: Int): Call<ApiResult<PageDTO<TestCaseModel>>>
}