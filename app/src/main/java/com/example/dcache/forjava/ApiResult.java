package com.example.dcache.forjava;

import dora.cache.data.adapter.Result;

/**
 * 响应数据根节点。
 *
 * @param <M>
 */
public class ApiResult<M> implements Result<M> {

    private M javaModel;

    @Override
    public M getRealModel() {
        return javaModel;
    }
}
