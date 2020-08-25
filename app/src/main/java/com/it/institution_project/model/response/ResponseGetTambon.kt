package com.it.institution_project.model.response

data class ResponseGetTambon(
    val data: List<MessageTambon>,
    val status: Int
)

data class MessageTambon(
    val amphur_id: Int,
    val tambon_name: String
)