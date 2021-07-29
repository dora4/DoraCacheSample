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
public class Nearest {

    private String status;
    private int distance;
    private int intensity;

    public void setStatus(String status) {
         this.status = status;
     }
     public String getStatus() {
         return status;
     }

    public void setDistance(int distance) {
         this.distance = distance;
     }
     public int getDistance() {
         return distance;
     }

    public void setIntensity(int intensity) {
         this.intensity = intensity;
     }
     public int getIntensity() {
         return intensity;
     }

    @Override
    public String toString() {
        return "Nearest{" +
                "status='" + status + '\'' +
                ", distance=" + distance +
                ", intensity=" + intensity +
                '}';
    }
}