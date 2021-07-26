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
public class Result {

    private Realtime realtime;
    private int primary;
    public void setRealtime(Realtime realtime) {
         this.realtime = realtime;
     }
     public Realtime getRealtime() {
         return realtime;
     }

    public void setPrimary(int primary) {
         this.primary = primary;
     }
     public int getPrimary() {
         return primary;
     }

    @Override
    public String toString() {
        return "Result{" +
                "realtime=" + realtime +
                ", primary=" + primary +
                '}';
    }
}