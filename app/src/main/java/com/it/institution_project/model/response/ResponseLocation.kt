package com.it.institution_project.model.response

data class ResponseLocation(
    val `data`: List<Data>,
    val status: Int
)

data class Data(
    val notic_lat: Double,
    val notic_long: Double
)