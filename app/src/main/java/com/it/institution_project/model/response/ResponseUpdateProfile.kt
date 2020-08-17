package com.it.institution_project.model.response

data class ResponseUpdateProfile(
    val message: MessageUpdateProfile,
    val status: Int
)

data class MessageUpdateProfile(
    val ins_name: String,
    val ins_district: String,
    val ins_locality: String,
    val ins_phone: String,
    val ins_username: String,
    val ins_password: String
)