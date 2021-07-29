package com.example.doracachesample.weather.biz

import com.example.doracachesample.weather.common.Result
import dora.db.converter.BaseJsonConverter
import dora.db.table.PropertyConverter

class ResultJsonConverter : BaseJsonConverter<Result>(), PropertyConverter<Result, String>