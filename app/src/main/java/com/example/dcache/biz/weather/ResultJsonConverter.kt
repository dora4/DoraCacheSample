package com.example.dcache.biz.weather

import com.example.dcache.model.common.Result
import dora.db.converter.BaseJsonConverter
import dora.db.converter.PropertyConverter

class ResultJsonConverter : BaseJsonConverter<Result>(), PropertyConverter<Result, String>