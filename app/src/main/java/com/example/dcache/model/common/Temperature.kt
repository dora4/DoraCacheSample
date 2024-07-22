/**
 * Copyright 2021 bejson.com
 */
package com.example.dcache.model.common

import dora.db.constraint.Id
import dora.db.constraint.NotNull
import dora.db.migration.OrmMigration
import dora.db.table.OrmTable

/**
 * Auto-generated: 2021-07-17 21:23:54
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
class Temperature : OrmTable {

    @Id
    private var id: Long = 0

    var addr: String = ""

    @NotNull
    lateinit var latlng: String

    val date: String? = null

    val max:Double = 0.0
    val min:Double = 0.0
    val avg:Double = 0.0

    override val isUpgradeRecreated: Boolean
        get() = false
    override val migrations: Array<OrmMigration>
        get() = arrayOf()

    override fun toString(): String {
        return "Temperature(id=$id, addr='$addr', latlng='$latlng', date=$date, max=$max, min=$min, avg=$avg)"
    }


}