/**
 * Copyright 2021 bejson.com
 */
package com.example.doracachesample.weather.biz

import com.example.doracachesample.weather.common.Result
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
    val status: String? = null
    val api_version: String? = null
    val api_status: String? = null
    val lang: String? = null
    val unit: String? = null
    val tzshift = 0
    val timezone: String? = null
    val server_time: Long = 0

    @Convert(converter = DoubleListConverter::class, columnType = String::class)
    val location: List<Double>? = null

    @Convert(converter = ResultJsonConverter::class, columnType = String::class)
    val result: Result? = null
    override fun toString(): String {
        return "WeatherModel{" +
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