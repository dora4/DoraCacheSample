/**
  * Copyright 2021 bejson.com 
  */
package com.example.doracachesample.realtime;

/**
 * Auto-generated: 2021-07-17 21:27:23
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Wind {

    private double speed;
    private int direction;
    public void setSpeed(double speed) {
         this.speed = speed;
     }
     public double getSpeed() {
         return speed;
     }

    public void setDirection(int direction) {
         this.direction = direction;
     }
     public int getDirection() {
         return direction;
     }

    @Override
    public String toString() {
        return "Wind{" +
                "speed=" + speed +
                ", direction=" + direction +
                '}';
    }
}