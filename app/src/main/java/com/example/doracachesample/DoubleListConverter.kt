package com.example.doracachesample

import dora.db.table.PropertyConverter
import java.util.*

class DoubleListConverter : PropertyConverter<List<Double>, String> {

    /**
     * 解析数据库的值赋值给实体类。
     *
     * @param databaseValue 数据库的值，如"a,b,c"
     * @return 如存放了a,b,c三个元素的List
     */
    override fun convertToEntityProperty(databaseValue: String?): List<Double>? {
        val result: MutableList<Double> = ArrayList()
        databaseValue?.split(",")?.forEach {
            result.add(it.toDouble())
        }
        return result
    }

    /**
     * 将复杂数据类型映射到数据库。
     *
     * @param entityProperty 如存放了a,b,c三个元素的List
     * @return 数据库的值，如"a,b,c"
     */
    override fun convertToDatabaseValue(entityProperty: List<Double>?): String? {
        val sb = StringBuilder()
        entityProperty?.let {
            for (link in it) {
                sb.append(link)
                sb.append(",")
            }
        }
        return sb.toString()
    }
}