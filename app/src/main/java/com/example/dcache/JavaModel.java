package com.example.dcache;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

import dora.db.migration.OrmMigration;
import dora.db.table.OrmTable;
import dora.db.table.PrimaryKeyEntry;

public class JavaModel implements OrmTable {

    @Override
    public boolean isUpgradeRecreated() {
        return false;
    }

    @NonNull
    @Override
    public PrimaryKeyEntry getPrimaryKey() {
        return null;
    }

    @NonNull
    @Override
    public OrmMigration[] getMigrations() {
        return new OrmMigration[0];
    }
}
