package com.example.dcache.biz.tutorial;

import androidx.annotation.Nullable;

import dora.db.constraint.Id;
import dora.db.migration.OrmMigration;
import dora.db.table.Column;
import dora.db.table.OrmTable;
import dora.db.table.Table;

@Table("tutorial")
public class Tutorial implements OrmTable {

    /**
     * 主键id。
     */
    @Id
    private long id;

    /**
     * Java成员属性对应数据库表的一个列（字段）
     */
    @Column("content")
    private String content;

    public Tutorial(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean isUpgradeRecreated() {
        return false;
    }

    @Nullable
    @Override
    public OrmMigration[] getMigrations() {
        return new OrmMigration[0];
    }
}
