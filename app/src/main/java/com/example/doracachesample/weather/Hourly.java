/**
  * Copyright 2021 bejson.com 
  */
package com.example.doracachesample.weather;
import java.util.List;

/**
 * Auto-generated: 2021-07-17 21:23:54
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Hourly {

    private String status;
    private String description;
    private List<Precipitation> precipitation;
    private List<Temperature> temperature;
    private List<Wind> wind;
    private List<Humidity> humidity;
    private List<Cloudrate> cloudrate;
    private List<Skycon> skycon;
    private List<Pressure> pressure;
    private List<Visibility> visibility;
    private List<Dswrf> dswrf;
    private Air_quality air_quality;
    public void setStatus(String status) {
         this.status = status;
     }
     public String getStatus() {
         return status;
     }

    public void setDescription(String description) {
         this.description = description;
     }
     public String getDescription() {
         return description;
     }

    public void setPrecipitation(List<Precipitation> precipitation) {
         this.precipitation = precipitation;
     }
     public List<Precipitation> getPrecipitation() {
         return precipitation;
     }

    public void setTemperature(List<Temperature> temperature) {
         this.temperature = temperature;
     }
     public List<Temperature> getTemperature() {
         return temperature;
     }

    public void setWind(List<Wind> wind) {
         this.wind = wind;
     }
     public List<Wind> getWind() {
         return wind;
     }

    public void setHumidity(List<Humidity> humidity) {
         this.humidity = humidity;
     }
     public List<Humidity> getHumidity() {
         return humidity;
     }

    public void setCloudrate(List<Cloudrate> cloudrate) {
         this.cloudrate = cloudrate;
     }
     public List<Cloudrate> getCloudrate() {
         return cloudrate;
     }

    public void setSkycon(List<Skycon> skycon) {
         this.skycon = skycon;
     }
     public List<Skycon> getSkycon() {
         return skycon;
     }

    public void setPressure(List<Pressure> pressure) {
         this.pressure = pressure;
     }
     public List<Pressure> getPressure() {
         return pressure;
     }

    public void setVisibility(List<Visibility> visibility) {
         this.visibility = visibility;
     }
     public List<Visibility> getVisibility() {
         return visibility;
     }

    public void setDswrf(List<Dswrf> dswrf) {
         this.dswrf = dswrf;
     }
     public List<Dswrf> getDswrf() {
         return dswrf;
     }

    public void setAir_quality(Air_quality air_quality) {
         this.air_quality = air_quality;
     }
     public Air_quality getAir_quality() {
         return air_quality;
     }

    @Override
    public String toString() {
        return "Hourly{" +
                "status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", precipitation=" + precipitation +
                ", temperature=" + temperature +
                ", wind=" + wind +
                ", humidity=" + humidity +
                ", cloudrate=" + cloudrate +
                ", skycon=" + skycon +
                ", pressure=" + pressure +
                ", visibility=" + visibility +
                ", dswrf=" + dswrf +
                ", air_quality=" + air_quality +
                '}';
    }
}