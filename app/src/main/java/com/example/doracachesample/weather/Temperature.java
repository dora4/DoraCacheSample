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
public class Temperature {

    private Date date;
    private int max;
    private int min;
    private double avg;
    public void setDate(Date date) {
         this.date = date;
     }
     public Date getDate() {
         return date;
     }

    public void setMax(int max) {
         this.max = max;
     }
     public int getMax() {
         return max;
     }

    public void setMin(int min) {
         this.min = min;
     }
     public int getMin() {
         return min;
     }

    public void setAvg(double avg) {
         this.avg = avg;
     }
     public double getAvg() {
         return avg;
     }

}