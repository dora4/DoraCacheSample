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
public class Precipitation {

    private Date date;
    private double max;
    private int min;
    private int avg;
    public void setDate(Date date) {
         this.date = date;
     }
     public Date getDate() {
         return date;
     }

    public void setMax(double max) {
         this.max = max;
     }
     public double getMax() {
         return max;
     }

    public void setMin(int min) {
         this.min = min;
     }
     public int getMin() {
         return min;
     }

    public void setAvg(int avg) {
         this.avg = avg;
     }
     public int getAvg() {
         return avg;
     }

}