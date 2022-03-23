package com.example.dcache;

import dora.cache.data.adapter.Result;

public class ApiResult<M> implements Result<M> {

    private M javaModel;

    @Override
    public M getRealModel() {
        return javaModel;
    }
}
