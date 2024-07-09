package com.example.dcache.biz.orm

import dora.db.constraint.Default
import dora.db.constraint.Id
import dora.db.constraint.NotNull
import dora.db.constraint.Unique
import dora.db.converter.StringListConverter
import dora.db.migration.OrmMigration
import dora.db.table.*

@Table("acc")
class Account : OrmTable {

    // @Id注解将自动配置主键，且列名以_id命名
    @Id
    val id: Long = 0

    @NotNull
    @Unique
    @Since(version = 1)
    @Column("acc_key")
    var accKey: String? = null

    @Default("")
    @Column("acc_desc")
    @Since(version = 1)
    var accDesc: String? = null

    @NotNull
    @Column("acc_value")
    @Since(version = 1)
    var accValue: String? = null

    /**
     * 跳过映射的属性。
     */
    @Ignore
    @Convert(converter = StringListConverter::class, columnType = String::class)
    @Since(version = 1)
    @Column("acc_child_values")
    var accChildValues: List<String>? = null

    constructor(accKey: String?, accDesc: String?, accValue: String?) {
        this.accKey = accKey
        this.accDesc = accDesc
        this.accValue = accValue
    }

    override val primaryKey: PrimaryKeyEntry
        get() = PrimaryKeyId(id)

    override val isUpgradeRecreated: Boolean
        get() = false
    override val migrations: Array<OrmMigration>
        get() = arrayOf()
}