package com.example.doracachesample.biz.orm.httpresult

import dora.http.retrofit.ApiService
import retrofit2.Call
import retrofit2.http.GET

interface TestService : ApiService {

    @GET("/?app=weather.today&weaId=1&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json")
    fun testRequest() : Call<JsonRootBean>
}