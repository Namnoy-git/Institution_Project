package com.it.institution_project.model.response

data class ResponseGetUser(
    val message: List<MessageGetUser>,
    val status: Int
)

data class MessageGetUser(
    val user_address: String,
    val user_email: String,
    val user_id: Int,
    val user_img: String,
    val user_name: String,
    val user_password: String,
    val user_phone: String,
    val user_role: String,
    val user_username: String
)