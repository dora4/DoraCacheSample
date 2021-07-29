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
public class Temperature {

    private String date;
    private int max;
    private int min;
    private double avg;

    public String getDate() {
        return date;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public double getAvg() {
        return avg;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "date='" + date + '\'' +
                ", max=" + max +
                ", min=" + min +
                ", avg=" + avg +
                '}';
    }
}