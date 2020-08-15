package com.it.institution_project.rest


import com.it.institution_project.model.body.BodyProfile
import com.it.institution_project.model.body.BodyShowStatus
import com.it.institution_project.model.response.ResponseLocation
import com.it.institution_project.model.response.ResponseProfile

import com.it.institution_project.ui.notifications.bodynoti.BodyUpdateNoti
import com.it.institution_project.ui.notifications.responsenoti.ResponseGetImageNoti
import com.it.institution_project.ui.notifications.responsenoti.ResponseGetNoti
import com.it.institution_project.ui.notifications.responsenoti.ResponseUpdatenoti
import com.it.institution_project.view.login.bodylogin.BodyLogin
import com.it.institution_project.view.login.responselogin.ResponseLogin
import io.reactivex.Observable
import retrofit2.http.*


interface ServiceAPI {

    //login
    @POST("/logininsti")
    fun doLogin(@Body body: BodyLogin?): Observable<ResponseLogin>

    // GetDataNoti
    @POST("/notiimage")
    fun doget(@Body body: BodyShowStatus?): Observable<ResponseGetNoti>

    @POST("/userprofile")
    fun doGetProfile(@Body body: BodyProfile?):Observable<ResponseProfile>

    @PUT("/updatenoti/{id}")
    fun UpdateNoti(@Path("id") notic_id: String, @Body body: BodyUpdateNoti?):Observable<ResponseUpdatenoti>

    @DELETE("/deletenoti/{id}")
    fun doDelete(@Path("id") id: Int): Observable<ResponseGetNoti>

    @POST("/usernoti")
    fun doGetNoti():Observable<ResponseGetNoti>


    //get image
    @GET("/getimage/{id}")
    fun dogetimage(@Path("id") userId: String): Observable<ResponseGetImageNoti>


    @GET("/getlocation")
    fun dogetlocation(): Observable<ResponseLocation>
}