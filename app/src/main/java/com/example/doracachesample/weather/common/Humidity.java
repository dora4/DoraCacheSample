/**
  * Copyright 2021 bejson.com 
  */
package com.example.doracachesample.weather.common;
import java.util.Date;

/**
 * Auto-generated: 2021-07-17 21:23:54
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Humidity {

    private String date;
    private double max;
    private double min;
    private double avg;
    public void setDate(String date) {
         this.date = date;
     }
     public String getDate() {
         return date;
     }

    public void setMax(double max) {
         this.max = max;
     }
     public double getMax() {
         return max;
     }

    public void setMin(double min) {
         this.min = min;
     }
     public double getMin() {
         return min;
     }

    public void setAvg(double avg) {
         this.avg = avg;
     }
     public double getAvg() {
         return avg;
     }

    @Override
    public String toString() {
        return "Humidity{" +
                "date='" + date + '\'' +
                ", max=" + max +
                ", min=" + min +
                ", avg=" + avg +
                '}';
    }
}