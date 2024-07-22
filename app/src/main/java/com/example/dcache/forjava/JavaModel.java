package com.example.dcache.forjava;

import androidx.annotation.NonNull;

import dora.db.migration.OrmMigration;
import dora.db.table.OrmTable;

/**
 * OrmTable实现类的Java写法。
 */
public class JavaModel implements OrmTable {

    @Override
    public boolean isUpgradeRecreated() {
        return false;
    }

    @NonNull
    @Override
    public OrmMigration[] getMigrations() {
        return new OrmMigration[0];
    }
}
