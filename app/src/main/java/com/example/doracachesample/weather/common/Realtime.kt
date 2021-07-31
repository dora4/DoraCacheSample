/**
 * Copyright 2021 bejson.com
 */
package com.example.doracachesample.weather.common

/**
 * Auto-generated: 2021-07-17 21:27:23
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
class Realtime {
    var status: String? = null
    var temperature = 0.0
    var humidity = 0.0
    var cloudrate = 0.0
    var skycon: String? = null
    var visibility = 0.0
    var dswrf = 0
    var wind: Wind? = null
    var pressure = 0.0
    var apparent_temperature = 0.0
    var precipitation: Precipitation? = null
    var air_quality: Air_quality? = null
    var life_index: Life_index? = null
    override fun toString(): String {
        return "Realtime{" +
                "status='" + status + '\'' +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", cloudrate=" + cloudrate +
                ", skycon='" + skycon + '\'' +
                ", visibility=" + visibility +
                ", dswrf=" + dswrf +
                ", wind=" + wind +
                ", pressure=" + pressure +
                ", apparent_temperature=" + apparent_temperature +
                ", precipitation=" + precipitation +
                ", air_quality=" + air_quality +
                ", life_index=" + life_index +
                '}'
    }
}