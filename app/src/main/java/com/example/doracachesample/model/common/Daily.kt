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
class Daily {
    var status: String? = null
    var astro: List<Astro>? = null
    var precipitation: List<Precipitation>? = null
    var temperature: List<Temperature>? = null
    var wind: List<Wind>? = null
    var humidity: List<Humidity>? = null
    var cloudrate: List<Cloudrate>? = null
    var pressure: List<Pressure>? = null
    var visibility: List<Visibility>? = null
    var dswrf: List<Dswrf>? = null
    var air_quality: Air_quality? = null
    var skycon: List<Skycon>? = null
    var skycon_08h_20h: List<Skycon_08h_20h>? = null
    var skycon_20h_32h: List<Skycon_20h_32h>? = null
    var life_index: Life_index? = null
    override fun toString(): String {
        return "Daily{" +
                "status='" + status + '\'' +
                ", astro=" + astro +
                ", precipitation=" + precipitation +
                ", temperature=" + temperature +
                ", wind=" + wind +
                ", humidity=" + humidity +
                ", cloudrate=" + cloudrate +
                ", pressure=" + pressure +
                ", visibility=" + visibility +
                ", dswrf=" + dswrf +
                ", air_quality=" + air_quality +
                ", skycon=" + skycon +
                ", skycon_08h_20h=" + skycon_08h_20h +
                ", skycon_20h_32h=" + skycon_20h_32h +
                ", life_index=" + life_index +
                '}'
    }
}