package com.example.doracachesample;

import android.content.Context;

import org.jetbrains.annotations.NotNull;

import dora.cache.repository.DoraDatabaseCacheRepository;

public class AccountRepository extends DoraDatabaseCacheRepository<Account> {

    public AccountRepository(@NotNull Context context) {
        super(context);
    }
}
