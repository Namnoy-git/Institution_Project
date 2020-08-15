package com.it.institution_project.ui.notifications.responsenoti

data class ResponseUpdatenoti(
    val message: Message,
    val status: Int
)

data class Message(

    val notic_status: String,
    val notic_steps: String

)