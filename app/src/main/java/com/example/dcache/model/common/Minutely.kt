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
class Minutely {
    var status: String? = null
    var datasource: String? = null
//    var precipitation_2h: List<Int>? = null
//    var precipitation: List<Int>? = null
//    var probability: List<Int>? = null
    var description: String? = null
    override fun toString(): String {
        return "Minutely{" +
                "status='" + status + '\'' +
                ", datasource='" + datasource + '\'' +
//                ", precipitation_2h=" + precipitation_2h +
//                ", precipitation=" + precipitation +
//                ", probability=" + probability +
                ", description='" + description + '\'' +
                '}'
    }
}