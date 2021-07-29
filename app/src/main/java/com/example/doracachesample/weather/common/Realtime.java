/**
  * Copyright 2021 bejson.com 
  */
package com.example.doracachesample.weather.common;

/**
 * Auto-generated: 2021-07-17 21:27:23
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Realtime {

    private String status;
    private double temperature;
    private double humidity;
    private double cloudrate;
    private String skycon;
    private double visibility;
    private int dswrf;
    private Wind wind;
    private double pressure;
    private double apparent_temperature;
    private Precipitation precipitation;
    private Air_quality air_quality;
    private Life_index life_index;
    public void setStatus(String status) {
         this.status = status;
     }
     public String getStatus() {
         return status;
     }

    public void setTemperature(double temperature) {
         this.temperature = temperature;
     }
     public double getTemperature() {
         return temperature;
     }

    public void setHumidity(double humidity) {
         this.humidity = humidity;
     }
     public double getHumidity() {
         return humidity;
     }

    public void setCloudrate(double cloudrate) {
         this.cloudrate = cloudrate;
     }
     public double getCloudrate() {
         return cloudrate;
     }

    public void setSkycon(String skycon) {
         this.skycon = skycon;
     }
     public String getSkycon() {
         return skycon;
     }

    public void setVisibility(double visibility) {
         this.visibility = visibility;
     }
     public double getVisibility() {
         return visibility;
     }

    public void setDswrf(int dswrf) {
         this.dswrf = dswrf;
     }
     public int getDswrf() {
         return dswrf;
     }

    public void setWind(Wind wind) {
         this.wind = wind;
     }
     public Wind getWind() {
         return wind;
     }

    public void setPressure(double pressure) {
         this.pressure = pressure;
     }
     public double getPressure() {
         return pressure;
     }

    public void setApparent_temperature(double apparent_temperature) {
         this.apparent_temperature = apparent_temperature;
     }
     public double getApparent_temperature() {
         return apparent_temperature;
     }

    public void setPrecipitation(Precipitation precipitation) {
         this.precipitation = precipitation;
     }
     public Precipitation getPrecipitation() {
         return precipitation;
     }

    public void setAir_quality(Air_quality air_quality) {
         this.air_quality = air_quality;
     }
     public Air_quality getAir_quality() {
         return air_quality;
     }

    public void setLife_index(Life_index life_index) {
         this.life_index = life_index;
     }
     public Life_index getLife_index() {
         return life_index;
     }

    @Override
    public String toString() {
        return "Realtime{" +
                "status='" + status + '\'' +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", cloudrate=" + cloudrate +
                ", skycon='" + skycon + '\'' +
                ", visibility=" + visibility +
                ", dswrf=" + dswrf +
                ", wind=" + wind +
                ", pressure=" + pressure +
                ", apparent_temperature=" + apparent_temperature +
                ", precipitation=" + precipitation +
                ", air_quality=" + air_quality +
                ", life_index=" + life_index +
                '}';
    }
}