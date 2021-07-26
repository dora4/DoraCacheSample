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
public class Precipitation {

    private String date;
    private double max;
    private double min;
    private double avg;

    public String getDate() {
        return date;
    }

    public double getMax() {
        return max;
    }

    public double getMin() {
        return min;
    }

    public double getAvg() {
        return avg;
    }

    @Override
    public String toString() {
        return "Precipitation{" +
                "date='" + date + '\'' +
                ", max=" + max +
                ", min=" + min +
                ", avg=" + avg +
                '}';
    }
}