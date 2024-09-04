package com.example.dcache.orm

import dora.db.converter.BaseJsonConverter
import dora.db.converter.PropertyConverter

class TestCaseModelConverter : BaseJsonConverter<TestCaseModel>(),
    PropertyConverter<TestCaseModel, String> {
}