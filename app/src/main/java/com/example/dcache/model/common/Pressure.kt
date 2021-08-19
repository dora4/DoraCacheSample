/**
 * Copyright 2021 bejson.com
 */
package com.example.dcache.model.common

/**
 * Auto-generated: 2021-07-17 21:23:54
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
class Pressure {
    var date: String? = null
    var max = 0.0
    var min = 0.0
    var avg = 0.0
    override fun toString(): String {
        return "Pressure{" +
                "date='" + date + '\'' +
                ", max=" + max +
                ", min=" + min +
                ", avg=" + avg +
                '}'
    }
}