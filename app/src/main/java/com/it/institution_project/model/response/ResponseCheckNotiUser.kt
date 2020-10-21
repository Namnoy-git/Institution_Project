package com.it.institution_project.model.response

data class ResponseCheckNotiUser(
    val results: List<Result>
)

data class Result(
    val locality: String,
    val message: String,
    val nt_id: Int,
    val status: String,
    val u_id: Int
)