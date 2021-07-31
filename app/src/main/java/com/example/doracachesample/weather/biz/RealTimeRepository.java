package com.example.doracachesample.weather.biz;

import android.content.Context;

import com.example.doracachesample.weather.realtime.RealTimeModel;

import org.jetbrains.annotations.NotNull;

import dora.cache.repository.DoraDatabaseCacheRepository;
import dora.cache.repository.Repository;
import dora.http.DoraCallback;
import dora.http.retrofit.DoraRetrofitManager;

@Repository(isListMode = false)
public class RealTimeRepository extends DoraDatabaseCacheRepository<RealTimeModel> {

    public RealTimeRepository(@NotNull Context context) {
        super(context);
    }

    @Override
    protected void onLoadFromNetwork(@NotNull DoraCallback<RealTimeModel> callback) {
        DoraRetrofitManager.INSTANCE.getService(WeatherService.class).getRealTime().enqueue(callback);
    }
}
