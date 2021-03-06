package com.it.institution_project.model.response

data class ResponseProfile(
    val message :ResponseProfileBody,
    val status: Int
)
data class ResponseProfileBody(
    val user_id :String,
    val user_name: String,
    val user_username: String,
    val user_img: String,
    val user_phone: String,
    val user_password:String,
    val user_email: String,
    val user_address: String,
    val user_role:String

)