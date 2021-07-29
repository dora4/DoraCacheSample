/**
  * Copyright 2021 bejson.com 
  */
package com.example.doracachesample.weather.biz;
import com.example.doracachesample.weather.common.Result;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import dora.db.OrmTable;
import dora.db.PrimaryKeyEntity;
import dora.db.PrimaryKeyId;
import dora.db.table.Convert;
import dora.db.table.Id;
import dora.db.table.Table;

/**
 * Auto-generated: 2021-07-17 21:23:54
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Table("weather")
public class WeatherModel implements OrmTable {

    @Id
    private long id;
    private String status;
    private String api_version;
    private String api_status;
    private String lang;
    private String unit;
    private int tzshift;
    private String timezone;
    private long server_time;
    @Convert(converter = DoubleListConverter.class, columnType = String.class)
    private List<Double> location;
    @Convert(converter = ResultJsonConverter.class, columnType = String.class)
    private Result result;

    public String getStatus() {
        return status;
    }

    public String getApi_version() {
        return api_version;
    }

    public String getApi_status() {
        return api_status;
    }

    public String getLang() {
        return lang;
    }

    public String getUnit() {
        return unit;
    }

    public int getTzshift() {
        return tzshift;
    }

    public String getTimezone() {
        return timezone;
    }

    public long getServer_time() {
        return server_time;
    }

    public List<Double> getLocation() {
        return location;
    }

    public Result getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "WeatherModel{" +
                "status='" + status + '\'' +
                ", api_version='" + api_version + '\'' +
                ", api_status='" + api_status + '\'' +
                ", lang='" + lang + '\'' +
                ", unit='" + unit + '\'' +
                ", tzshift=" + tzshift +
                ", timezone='" + timezone + '\'' +
                ", server_time=" + server_time +
                ", location=" + location +
                ", result=" + result +
                '}';
    }

    @Override
    public boolean isUpgradeRecreated() {
        return false;
    }

    @NotNull
    @Override
    public PrimaryKeyEntity getPrimaryKey() {
        return new PrimaryKeyId(id);
    }
}