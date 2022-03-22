package com.example.dcache.biz;

import android.content.Context;

import com.example.dcache.JavaModel;
import com.example.dcache.ResultService;

import org.jetbrains.annotations.NotNull;

import dora.cache.data.result.ResultAdapter;
import dora.cache.repository.DoraDatabaseCacheRepository;
import dora.http.DoraCallback;
import dora.http.DoraListCallback;
import dora.http.retrofit.JRetrofitManager;
import dora.http.retrofit.RetrofitManager;

public class JavaRepository extends DoraDatabaseCacheRepository<JavaModel> {

    public JavaRepository(@NotNull Context context) {
        super(context);
    }

    @Override
    protected void onLoadFromNetwork(@NotNull DoraCallback<JavaModel> callback) {
        super.onLoadFromNetwork(callback);
        JRetrofitManager.Companion.getService(ResultService.class).getResult().enqueue(new ResultAdapter(callback));
    }

    @Override
    protected void onLoadFromNetwork(@NotNull DoraListCallback<JavaModel> callback) {
        super.onLoadFromNetwork(callback);
    }
}
