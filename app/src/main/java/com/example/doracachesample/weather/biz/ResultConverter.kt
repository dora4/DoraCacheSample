package com.example.doracachesample.weather.biz

import com.example.doracachesample.weather.common.Result
import com.google.gson.Gson
import dora.db.table.PropertyConverter

class ResultConverter : PropertyConverter<Result, String> {

    override fun convertToDatabaseValue(entityProperty: Result?): String? {
        if (entityProperty != null) {
            return Gson().toJson(entityProperty.daily.temperature)
        } else {
            return ""
        }
    }

    override fun convertToEntityProperty(databaseValue: String?): Result? {
        if (!databaseValue.equals("")) {
            return Gson().fromJson(databaseValue, Result::class.java)
        } else {
            return null
        }
    }
}