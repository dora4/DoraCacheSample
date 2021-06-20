package com.example.doracachesample;

import dora.db.OrmTable;
import dora.db.PrimaryKeyEntity;
import dora.db.PrimaryKeyId;
import dora.db.constraint.AssignType;
import dora.db.constraint.Default;
import dora.db.constraint.NotNull;
import dora.db.constraint.PrimaryKey;
import dora.db.constraint.Unique;
import dora.db.table.Column;
import dora.db.table.Id;
import dora.db.table.Table;

@Table("acc")
public class Account implements OrmTable {

    //Id注解将自动配置主键，且以_id命名
    @Id
    private long id;

    @NotNull
    @Unique
    @Column("acc_key")
    private String accKey;

    @Default("")
    @Column("acc_desc")
    private String accDesc;

    @NotNull
    @Column("acc_value")
    private String accValue;

    /**
     * 务必保留，框架要求无参构造方法
     */
    public Account() {
    }

    public Account(String accKey, String accDesc, String accValue) {
        this.accKey = accKey;
        this.accDesc = accDesc;
        this.accValue = accValue;
    }

    @Override
    public PrimaryKeyEntity getPrimaryKey() {
        return new PrimaryKeyId(id);
    }

    public long getId() {
        return id;
    }

    public String getAccKey() {
        return accKey;
    }

    public void setAccKey(String accKey) {
        this.accKey = accKey;
    }

    public String getAccDesc() {
        return accDesc;
    }

    public void setAccDesc(String accDesc) {
        this.accDesc = accDesc;
    }

    public String getAccValue() {
        return accValue;
    }

    public void setAccValue(String accValue) {
        this.accValue = accValue;
    }

    @Override
    public boolean isUpgradeRecreated() {
        return false;
    }
}
