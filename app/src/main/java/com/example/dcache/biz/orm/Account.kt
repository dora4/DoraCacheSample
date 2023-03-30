package com.example.dcache.biz.orm

import dora.db.constraint.Default
import dora.db.constraint.NotNull
import dora.db.constraint.Unique
import dora.db.converter.StringListConverter
import dora.db.table.*

@Table("acc")
class Account : OrmTable {
    //Id注解将自动配置主键，且以_id命名
    @Id
    val id: Long = 0

    @NotNull
    @Unique
    @Column("acc_key")
    var accKey: String? = null

    @Default("")
    @Column("acc_desc")
    var accDesc: String? = null

    @NotNull
    @Column("acc_value")
    var accValue: String? = null

    @Ignore
    @Convert(converter = StringListConverter::class, columnType = String::class)
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
}