/**
 * Copyright 2021 bejson.com
 */
package com.example.dcache.model

import com.example.dcache.biz.weather.DoubleListConverter
import com.example.dcache.biz.weather.ResultJsonConverter
import com.example.dcache.model.common.Result
import dora.db.constraint.Id
import dora.db.migration.OrmMigration
import dora.db.table.*

/**
 * Auto-generated: 2021-07-17 21:23:54
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Table("weather")
class WeatherModel : OrmTable {
    @Id
    private val id: Long = 0
    // 如ok
    val status: String? = null
    // 如v2.5
    val api_version: String? = null
    // 如active
    val api_status: String? = null
    // 如zh_CN
    val lang: String? = null
    // 如metric
    val unit: String? = null
    // 如28800
    val tzshift = 0
    // 如Asia\/Shanghai
    val timezone: String? = null
    // 如1629380623
    val server_time: Long = 0
    // 如39.90403,116.407526
    @Convert(converter = DoubleListConverter::class, columnType = String::class)
    val location: MutableList<Double>? = null

    @Convert(converter = ResultJsonConverter::class, columnType = String::class)
    val result: Result? = null

    override val isUpgradeRecreated: Boolean
        get() = false
    override val migrations: Array<OrmMigration>
        get() = arrayOf()

    override fun toString(): String {
        return "WeatherModel(id=$id, status=$status, api_version=$api_version, api_status=$api_status, lang=$lang, unit=$unit, tzshift=$tzshift, timezone=$timezone, server_time=$server_time, location=$location, result=$result)"
    }
}