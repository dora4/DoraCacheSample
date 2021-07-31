package com.example.doracachesample.weather.biz;

import android.content.Context;

import com.example.doracachesample.weather.daily.DailyModel;

import org.jetbrains.annotations.NotNull;

import dora.cache.repository.DoraDatabaseCacheRepository;
import dora.cache.repository.Repository;
import dora.http.DoraCallback;
import dora.http.retrofit.DoraRetrofitManager;

@Repository(isListMode = false)
public class DailyRepository extends DoraDatabaseCacheRepository<DailyModel> {

    public DailyRepository(@NotNull Context context) {
        super(context);
    }

    @Override
    protected void onLoadFromNetwork(@NotNull DoraCallback<DailyModel> callback) {
        DoraRetrofitManager.INSTANCE.getService(WeatherService.class).getDaily().enqueue(callback);
    }
}
