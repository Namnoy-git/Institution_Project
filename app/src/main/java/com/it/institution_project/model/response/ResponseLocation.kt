package com.it.institution_project.model.response

data class ResponseLocation(
    val `data`: List<Data>,
    val status: Int
)

data class Data(
    val notic_lat: String,
    val notic_long: String
)