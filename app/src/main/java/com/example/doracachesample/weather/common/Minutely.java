/**
  * Copyright 2021 bejson.com 
  */
package com.example.doracachesample.weather.common;
import java.util.List;

/**
 * Auto-generated: 2021-07-17 21:23:54
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Minutely {

    private String status;
    private String datasource;
    private List<Integer> precipitation_2h;
    private List<Integer> precipitation;
    private List<Integer> probability;
    private String description;
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

    public void setPrecipitation_2h(List<Integer> precipitation_2h) {
         this.precipitation_2h = precipitation_2h;
     }
     public List<Integer> getPrecipitation_2h() {
         return precipitation_2h;
     }

    public void setPrecipitation(List<Integer> precipitation) {
         this.precipitation = precipitation;
     }
     public List<Integer> getPrecipitation() {
         return precipitation;
     }

    public void setProbability(List<Integer> probability) {
         this.probability = probability;
     }
     public List<Integer> getProbability() {
         return probability;
     }

    public void setDescription(String description) {
         this.description = description;
     }
     public String getDescription() {
         return description;
     }

    @Override
    public String toString() {
        return "Minutely{" +
                "status='" + status + '\'' +
                ", datasource='" + datasource + '\'' +
                ", precipitation_2h=" + precipitation_2h +
                ", precipitation=" + precipitation +
                ", probability=" + probability +
                ", description='" + description + '\'' +
                '}';
    }
}