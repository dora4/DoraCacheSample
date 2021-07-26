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
public class Daily {

    private String status;
    private List<Astro> astro;
    private List<Precipitation> precipitation;
    private List<Temperature> temperature;
    private List<Wind> wind;
    private List<Humidity> humidity;
    private List<Cloudrate> cloudrate;
    private List<Pressure> pressure;
    private List<Visibility> visibility;
    private List<Dswrf> dswrf;
    private Air_quality air_quality;
    private List<Skycon> skycon;
    private List<Skycon_08h_20h> skycon_08h_20h;
    private List<Skycon_20h_32h> skycon_20h_32h;
    private Life_index life_index;
    public void setStatus(String status) {
         this.status = status;
     }
     public String getStatus() {
         return status;
     }

    public void setAstro(List<Astro> astro) {
         this.astro = astro;
     }
     public List<Astro> getAstro() {
         return astro;
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

    public void setSkycon(List<Skycon> skycon) {
         this.skycon = skycon;
     }
     public List<Skycon> getSkycon() {
         return skycon;
     }

    public void setSkycon_08h_20h(List<Skycon_08h_20h> skycon_08h_20h) {
         this.skycon_08h_20h = skycon_08h_20h;
     }
     public List<Skycon_08h_20h> getSkycon_08h_20h() {
         return skycon_08h_20h;
     }

    public void setSkycon_20h_32h(List<Skycon_20h_32h> skycon_20h_32h) {
         this.skycon_20h_32h = skycon_20h_32h;
     }
     public List<Skycon_20h_32h> getSkycon_20h_32h() {
         return skycon_20h_32h;
     }

    public void setLife_index(Life_index life_index) {
         this.life_index = life_index;
     }
     public Life_index getLife_index() {
         return life_index;
     }

    @Override
    public String toString() {
        return "Daily{" +
                "status='" + status + '\'' +
                ", astro=" + astro +
                ", precipitation=" + precipitation +
                ", temperature=" + temperature +
                ", wind=" + wind +
                ", humidity=" + humidity +
                ", cloudrate=" + cloudrate +
                ", pressure=" + pressure +
                ", visibility=" + visibility +
                ", dswrf=" + dswrf +
                ", air_quality=" + air_quality +
                ", skycon=" + skycon +
                ", skycon_08h_20h=" + skycon_08h_20h +
                ", skycon_20h_32h=" + skycon_20h_32h +
                ", life_index=" + life_index +
                '}';
    }
}