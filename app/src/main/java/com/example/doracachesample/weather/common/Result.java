/**
  * Copyright 2021 bejson.com 
  */
package com.example.doracachesample.weather.common;

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

    public Realtime getRealtime() {
        return realtime;
    }

    public Minutely getMinutely() {
        return minutely;
    }

    public Hourly getHourly() {
        return hourly;
    }

    public Daily getDaily() {
        return daily;
    }

    public int getPrimary() {
        return primary;
    }

    public String getForecast_keypoint() {
        return forecast_keypoint;
    }

    @Override
    public String toString() {
        return "Result{" +
                "realtime=" + realtime +
                ", minutely=" + minutely +
                ", hourly=" + hourly +
                ", daily=" + daily +
                ", primary=" + primary +
                ", forecast_keypoint='" + forecast_keypoint + '\'' +
                '}';
    }
}