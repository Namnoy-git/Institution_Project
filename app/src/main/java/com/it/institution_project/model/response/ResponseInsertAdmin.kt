package com.it.institution_project.model.response

data class ResponseInsertAdmin(

    val message: Message,
    val status: Int
)

data class Message(
    val ins_district: String,
    val ins_locality: String,
    val ins_name: String,
    val ins_password: String,
    val ins_phone: String,
    val ins_username: String
)