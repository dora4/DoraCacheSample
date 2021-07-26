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
public class Aqi {

    private int chn;
    private int usa;
    public void setChn(int chn) {
         this.chn = chn;
     }
     public int getChn() {
         return chn;
     }

    public void setUsa(int usa) {
         this.usa = usa;
     }
     public int getUsa() {
         return usa;
     }

    @Override
    public String toString() {
        return "Aqi{" +
                "chn=" + chn +
                ", usa=" + usa +
                '}';
    }
}