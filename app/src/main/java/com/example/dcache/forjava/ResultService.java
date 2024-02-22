package com.example.dcache.forjava;

import dora.http.retrofit.ApiService;
import retrofit2.Call;

/**
 * API接口Java的写法。
 */
public interface ResultService extends ApiService {

    Call<ApiResult<JavaModel>> getResult();
}
