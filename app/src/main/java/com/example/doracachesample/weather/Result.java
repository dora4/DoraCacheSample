/**
  * Copyright 2021 bejson.com 
  */
package com.example.doracachesample.weather;

/**
 * Auto-generated: 2021-07-17 21:23:54
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Result {

    private Realtime realtime;
    private Minutely minutely;
    private Hourly hourly;
    private Daily daily;
    private int primary;
    private String forecast_keypoint;
    public void setRealtime(Realtime realtime) {
         this.realtime = realtime;
     }
     public Realtime getRealtime() {
         return realtime;
     }

    public void setMinutely(Minutely minutely) {
         this.minutely = minutely;
     }
     public Minutely getMinutely() {
         return minutely;
     }

    public void setHourly(Hourly hourly) {
         this.hourly = hourly;
     }
     public Hourly getHourly() {
         return hourly;
     }

    public void setDaily(Daily daily) {
         this.daily = daily;
     }
     public Daily getDaily() {
         return daily;
     }

    public void setPrimary(int primary) {
         this.primary = primary;
     }
     public int getPrimary() {
         return primary;
     }

    public void setForecast_keypoint(String forecast_keypoint) {
         this.forecast_keypoint = forecast_keypoint;
     }
     public String getForecast_keypoint() {
         return forecast_keypoint;
     }

}