/**
 * Copyright 2021 bejson.com
 */
package com.example.dcache.model.common

/**
 * Auto-generated: 2021-07-17 21:27:23
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
class Realtime {
    // 如ok
    var status: String? = null
    // 如20.0
    var temperature: Double = 0.0
    // 如0.95
    var humidity: Double = 0.0
    // 如1.0
    var cloudrate: Double = 0.0
    // 如CLOUDY
    var skycon: String? = null
    // 如6.5
    var visibility: Double = 0.0
    // 如0.0
    var dswrf: Double = 0.0
    var wind: Wind? = null
    // 如100280.67
    var pressure: Double = 0.0
    // 如22.1
    var apparent_temperature: Double = 0.0
//    var precipitation: Precipitation? = null
//    var air_quality: Air_quality? = null
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
//                ", precipitation=" + precipitation +
//                ", air_quality=" + air_quality +
                ", life_index=" + life_index +
                '}'
    }
}