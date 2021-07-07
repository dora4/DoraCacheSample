package com.example.doracachesample

import dora.http.retrofit.ApiService
import retrofit2.Call
import retrofit2.http.GET

interface AccountService : ApiService {

    @GET
    fun getAccount() : Call<Account>
}