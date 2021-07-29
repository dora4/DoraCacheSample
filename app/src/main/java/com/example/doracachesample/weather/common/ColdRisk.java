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
public class ColdRisk {

    private String date;
    private String index;
    private String desc;
    public void setDate(String date) {
         this.date = date;
     }
     public String getDate() {
         return date;
     }

    public void setIndex(String index) {
         this.index = index;
     }
     public String getIndex() {
         return index;
     }

    public void setDesc(String desc) {
         this.desc = desc;
     }
     public String getDesc() {
         return desc;
     }

    @Override
    public String toString() {
        return "ColdRisk{" +
                "date='" + date + '\'' +
                ", index='" + index + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}