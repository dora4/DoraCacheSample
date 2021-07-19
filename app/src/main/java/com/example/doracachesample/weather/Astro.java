/**
  * Copyright 2021 bejson.com 
  */
package com.example.doracachesample.weather;
import java.util.Date;

/**
 * Auto-generated: 2021-07-17 21:23:54
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Astro {

    private Date date;
    private Sunrise sunrise;
    private Sunset sunset;
    public void setDate(Date date) {
         this.date = date;
     }
     public Date getDate() {
         return date;
     }

    public void setSunrise(Sunrise sunrise) {
         this.sunrise = sunrise;
     }
     public Sunrise getSunrise() {
         return sunrise;
     }

    public void setSunset(Sunset sunset) {
         this.sunset = sunset;
     }
     public Sunset getSunset() {
         return sunset;
     }

}