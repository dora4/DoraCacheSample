package com.example.dcache;

import org.jetbrains.annotations.NotNull;

import dora.db.table.OrmTable;
import dora.db.table.PrimaryKeyEntry;

public class JavaModel implements OrmTable {

    @Override
    public boolean isUpgradeRecreated() {
        return false;
    }

    @NotNull
    @Override
    public PrimaryKeyEntry getPrimaryKey() {
        return null;
    }
}
