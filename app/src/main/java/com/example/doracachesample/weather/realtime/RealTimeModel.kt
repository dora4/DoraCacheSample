/**
 * Copyright 2021 bejson.com
 */
package com.example.doracachesample.weather.realtime

import com.example.doracachesample.weather.biz.DoubleListConverter
import com.example.doracachesample.weather.biz.ResultJsonConverter
import com.example.doracachesample.weather.common.Result
import dora.db.table.*

/**
 * Auto-generated: 2021-07-17 21:27:23
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Table("real_time")
class RealTimeModel : OrmTable {
    @Id
    val id: Long = 0
    var status: String? = null
    var api_version: String? = null
    var api_status: String? = null
    var lang: String? = null
    var unit: String? = null
    var tzshift = 0
    var timezone: String? = null
    var server_time: Long = 0

    @Convert(converter = DoubleListConverter::class, columnType = String::class)
    var location: List<Double>? = null

    @Convert(converter = ResultJsonConverter::class, columnType = String::class)
    var result: Result? = null
    override fun toString(): String {
        return "RealTimeModel{" +
                "status='" + status + '\'' +
                ", api_version='" + api_version + '\'' +
                ", api_status='" + api_status + '\'' +
                ", lang='" + lang + '\'' +
                ", unit='" + unit + '\'' +
                ", tzshift=" + tzshift +
                ", timezone='" + timezone + '\'' +
                ", server_time=" + server_time +
                ", location=" + location +
                ", result=" + result +
                '}'
    }

    override val isUpgradeRecreated: Boolean
        get() = false
    override val primaryKey: PrimaryKeyEntity
        get() = PrimaryKeyId(id)
}