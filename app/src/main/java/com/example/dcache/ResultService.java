package com.example.dcache;

import dora.http.retrofit.ApiService;
import retrofit2.Call;

public interface ResultService extends ApiService {

    Call<ApiResult<JavaModel>> getResult();
}
