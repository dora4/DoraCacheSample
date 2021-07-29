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
public class Local {

    private String status;
    private String datasource;
    private int intensity;
    public void setStatus(String status) {
         this.status = status;
     }
     public String getStatus() {
         return status;
     }

    public void setDatasource(String datasource) {
         this.datasource = datasource;
     }
     public String getDatasource() {
         return datasource;
     }

    public void setIntensity(int intensity) {
         this.intensity = intensity;
     }
     public int getIntensity() {
         return intensity;
     }

    @Override
    public String toString() {
        return "Local{" +
                "status='" + status + '\'' +
                ", datasource='" + datasource + '\'' +
                ", intensity=" + intensity +
                '}';
    }
}