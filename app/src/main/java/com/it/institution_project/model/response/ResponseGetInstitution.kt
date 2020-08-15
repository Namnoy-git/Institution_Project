package com.it.institution_project.model.response

data class ResponseGetInstitution(
    val message: List<MessageGetInstitution>,
    val status: Int
)

data class MessageGetInstitution(
    val ins_district: String,
    val ins_id: Int,
    val ins_locality: String,
    val ins_name: String,
    val ins_password: String,
    val ins_phone: String,
    val ins_province: String,
    val ins_username: String
)