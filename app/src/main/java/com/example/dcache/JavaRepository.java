package com.example.dcache;

import android.content.Context;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.sql.DataSource;

import dora.cache.data.adapter.ListResultAdapter;
import dora.cache.data.adapter.ResultAdapter;
import dora.cache.repository.DoraDatabaseCacheRepository;
import dora.http.DoraCallback;
import dora.http.DoraListCallback;
import dora.http.retrofit.RetrofitManager;

public class JavaRepository extends DoraDatabaseCacheRepository<JavaModel> {

    public JavaRepository(@NotNull Context context) {
        super(context);
    }

    @Override
    protected void onInterceptData(@NotNull DataSource.Type type, @NotNull List<? extends JavaModel> models) {
        super.onInterceptData(type, models);
    }

    @Override
    protected void onInterceptData(@NotNull DataSource.Type type, JavaModel model) {
        super.onInterceptData(type, model);
    }

    @Override
    protected void onLoadFromNetwork(@NotNull DoraCallback<JavaModel> callback) {
        super.onLoadFromNetwork(callback);
        RetrofitManager.INSTANCE.getService(ResultService.class).getResult().enqueue(new ResultAdapter(callback));
    }

    @Override
    protected void onLoadFromNetwork(@NotNull DoraListCallback<JavaModel> callback) {
        super.onLoadFromNetwork(callback);
        RetrofitManager.INSTANCE.getService(ResultService.class).getResult().enqueue(new ListResultAdapter(callback));
    }
}
