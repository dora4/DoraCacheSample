package com.example.doracachesample.biz.weather

import com.example.doracachesample.model.common.Result
import dora.db.converter.BaseJsonConverter
import dora.db.converter.PropertyConverter

class ResultJsonConverter : BaseJsonConverter<Result>(), PropertyConverter<Result, String>