/**
 * Copyright 2021 bejson.com
 */
package com.example.doracachesample.model.common

/**
 * Auto-generated: 2021-07-17 21:23:54
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
class Result {
    val realtime: Realtime? = null
    val minutely: Minutely? = null
    val hourly: Hourly? = null
    val daily: Daily? = null
    val primary = 0
    val forecast_keypoint: String? = null
    override fun toString(): String {
        return "Result{" +
                "realtime=" + realtime +
                ", minutely=" + minutely +
                ", hourly=" + hourly +
                ", daily=" + daily +
                ", primary=" + primary +
                ", forecast_keypoint='" + forecast_keypoint + '\'' +
                '}'
    }
}