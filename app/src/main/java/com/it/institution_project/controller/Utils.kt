package com.it.institution_project.controller

import com.google.gson.Gson
import com.google.gson.GsonBuilder


class Utils {

    companion object{
        const val BaseUrl = "http://10.99.1.117:4000"
    }

    fun getGson(): Gson? {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setDateFormat("M/d/yy hh:mm a")
        return gsonBuilder.create()
    }
}