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
public class Aqi {

    private String date;
    private Max max;
    private Avg avg;
    private Min min;
    public void setDate(String date) {
         this.date = date;
     }
     public String getDate() {
         return date;
     }

    public void setMax(Max max) {
         this.max = max;
     }
     public Max getMax() {
         return max;
     }

    public void setAvg(Avg avg) {
         this.avg = avg;
     }
     public Avg getAvg() {
         return avg;
     }

    public void setMin(Min min) {
         this.min = min;
     }
     public Min getMin() {
         return min;
     }

    @Override
    public String toString() {
        return "Aqi{" +
                "date='" + date + '\'' +
                ", max=" + max +
                ", avg=" + avg +
                ", min=" + min +
                '}';
    }
}