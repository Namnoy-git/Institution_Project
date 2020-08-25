package com.it.institution_project.view.login.responselogin

data class ResponseLogin(
    val message: Message,
    val status: Int
)

data class Message(
    val ins_id: Int,
    val ins_password: String,
    val ins_username: String,
//    val ins_district: String,
//    val ins_locality: String,
    val token: String
)