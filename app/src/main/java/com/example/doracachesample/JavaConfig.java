package com.example.doracachesample;

import com.example.doracachesample.httpresult.TestService;

import java.util.List;

import dora.http.retrofit.DoraRetrofitManager;
import okhttp3.Authenticator;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

public class JavaConfig {

    private void config() {
        DoraRetrofitManager.INSTANCE.setClient(new OkHttpClient());
        DoraRetrofitManager.INSTANCE.getConfig()
            .registerBaseUrl(TestService.class, "http://api.k780.com")
            .registerBaseUrl(AccountService.class, "http://github.com/dora4");
    }
}
