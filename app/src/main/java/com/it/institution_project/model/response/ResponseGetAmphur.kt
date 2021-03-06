package com.it.institution_project.model.response

data class ResponseGetAmphur(
    val `data`: List<DataAmphur>,
    val status: Int
)

data class DataAmphur(
    val amphur_name: String,
    val tambon_name: String
)