package com.example.doracachesample.weather.biz;

import android.content.Context;

import org.jetbrains.annotations.NotNull;

import dora.cache.repository.BaseRepository;
import dora.cache.repository.DoraDatabaseCacheRepository;
import dora.cache.repository.Repository;
import dora.http.DoraCallback;
import dora.http.retrofit.DoraRetrofitManager;

@Repository(cacheStrategy = BaseRepository.CacheStrategy.DATABASE_CACHE, modelClass = WeatherModel.class, isListMode = false)
public class WeatherRepository extends DoraDatabaseCacheRepository<WeatherModel> {

    public WeatherRepository(@NotNull Context context) {
        super(context);
    }

    @Override
    protected void onLoadFromNetwork(@NotNull DoraCallback<WeatherModel> callback) {
        DoraRetrofitManager.INSTANCE.getService(WeatherService.class).getWeather().enqueue(callback);
    }

    @Override
    public boolean isNoNetworkMode() {
        return false;
    }
}
