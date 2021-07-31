/**
 * Copyright 2021 bejson.com
 */
package com.example.doracachesample.weather.common

/**
 * Auto-generated: 2021-07-17 21:23:54
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
class Hourly {
    var status: String? = null
    var description: String? = null
    var precipitation: List<Precipitation>? = null
    var temperature: List<Temperature>? = null
    var wind: List<Wind>? = null
    var humidity: List<Humidity>? = null
    var cloudrate: List<Cloudrate>? = null
    var skycon: List<Skycon>? = null
    var pressure: List<Pressure>? = null
    var visibility: List<Visibility>? = null
    var dswrf: List<Dswrf>? = null
    var air_quality: Air_quality? = null
    override fun toString(): String {
        return "Hourly{" +
                "status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", precipitation=" + precipitation +
                ", temperature=" + temperature +
                ", wind=" + wind +
                ", humidity=" + humidity +
                ", cloudrate=" + cloudrate +
                ", skycon=" + skycon +
                ", pressure=" + pressure +
                ", visibility=" + visibility +
                ", dswrf=" + dswrf +
                ", air_quality=" + air_quality +
                '}'
    }
}