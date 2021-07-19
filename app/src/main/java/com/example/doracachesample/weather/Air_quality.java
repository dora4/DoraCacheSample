/**
  * Copyright 2021 bejson.com 
  */
package com.example.doracachesample.weather;
import java.util.List;

/**
 * Auto-generated: 2021-07-17 21:23:54
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Air_quality {

    private List<Aqi> aqi;
    private List<Pm25> pm25;
    public void setAqi(List<Aqi> aqi) {
         this.aqi = aqi;
     }
     public List<Aqi> getAqi() {
         return aqi;
     }

    public void setPm25(List<Pm25> pm25) {
         this.pm25 = pm25;
     }
     public List<Pm25> getPm25() {
         return pm25;
     }

}