package com.example.dcache.forjava;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import dora.cache.data.adapter.ListResultAdapter;
import dora.cache.data.adapter.ResultAdapter;
import dora.cache.data.fetcher.OnLoadStateListener;
import dora.cache.factory.DatabaseCacheHolderFactory;
import dora.cache.repository.DoraDatabaseCacheRepository;
import dora.cache.repository.Repository;
import dora.http.DoraCallback;
import dora.http.DoraListCallback;
import dora.http.retrofit.RetrofitManager;

/**
 * Repository的Java写法。
 */
@Repository
public class JavaRepository extends DoraDatabaseCacheRepository<JavaModel> {

    public JavaRepository(@NotNull Context context) {
        super(context);
    }

    @Override
    protected void onInterceptData(@NonNull DataSource.Type type, @NonNull List<JavaModel> models) {
        super.onInterceptData(type, models);
    }

    @Override
    protected void onInterceptData(@NotNull DataSource.Type type, JavaModel model) {
        super.onInterceptData(type, model);
    }

    @Override
    protected void onLoadFromNetwork(@NonNull DoraCallback<JavaModel> callback, @Nullable OnLoadStateListener listener) {
        super.onLoadFromNetwork(callback, listener);
        RetrofitManager.INSTANCE.getService(ResultService.class).getResult().enqueue(new ResultAdapter(callback));
    }

    @Override
    protected void onLoadFromNetwork(@NonNull DoraListCallback<JavaModel> callback, @Nullable OnLoadStateListener listener) {
        super.onLoadFromNetwork(callback, listener);
        RetrofitManager.INSTANCE.getService(ResultService.class).getResult().enqueue(new ListResultAdapter(callback));
    }

    @NonNull
    @Override
    protected DatabaseCacheHolderFactory<JavaModel> createCacheHolderFactory() {
        return new DatabaseCacheHolderFactory<>(JavaModel.class);
    }
}
