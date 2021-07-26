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
public class Wind {

    private String date;
    private Max max;
    private Min min;
    private Avg avg;

    public String getDate() {
        return date;
    }

    public Max getMax() {
        return max;
    }

    public Min getMin() {
        return min;
    }

    public Avg getAvg() {
        return avg;
    }

    @Override
    public String toString() {
        return "Wind{" +
                "date='" + date + '\'' +
                ", max=" + max +
                ", min=" + min +
                ", avg=" + avg +
                '}';
    }
}