/**
 * Copyright 2021 bejson.com
 */
package com.example.doracachesample.model.common

import dora.db.constraint.NotNull
import dora.db.table.Id
import dora.db.table.OrmTable
import dora.db.table.PrimaryKeyEntity
import dora.db.table.PrimaryKeyId

/**
 * Auto-generated: 2021-07-17 21:23:54
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
class Temperature : OrmTable {

    @Id
    private var id: Long = 0

    @NotNull
    lateinit var latlng: String

    val date: String? = null
    val max = 0
    val min = 0
    val avg = 0.0

    override val isUpgradeRecreated: Boolean
        get() = false
    override val primaryKey: PrimaryKeyEntity
        get() = PrimaryKeyId(id)

    override fun toString(): String {
        return "Temperature{" +
                "date='" + date + '\'' +
                ", max=" + max +
                ", min=" + min +
                ", avg=" + avg +
                '}'
    }
}