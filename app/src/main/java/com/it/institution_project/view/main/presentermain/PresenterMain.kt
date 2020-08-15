package com.it.institution_project.view.main.presentermain

import android.util.Log
import com.it.institution_project.model.body.BodyProfile
import com.it.institution_project.model.body.BodyShowStatus
import com.it.institution_project.model.response.ResponseLocation
import com.it.institution_project.model.response.ResponseProfile
import com.it.institution_project.rest.DataModule
import com.it.institution_project.ui.notifications.responsenoti.ResponseGetImageNoti
import com.it.institution_project.ui.notifications.responsenoti.ResponseGetNoti
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class PresenterMain {

    var mDisposable: Disposable? = null

    fun GetDataNotiRx(
          notic_status: String,
        datarResponse:(ResponseGetNoti)->Unit,
        MessageError:(String)->Unit
    ){
        mDisposable = DataModule.myAppService.doget(BodyShowStatus(notic_status))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ResponseGetNoti>(){

                override fun onComplete() {

                }

                override fun onNext(response: ResponseGetNoti) {
                    Log.d("messageget",response.toString())
                    datarResponse.invoke(response)

                }

                override fun onError(e: Throwable) {
                    Log.d("messageget",e.message)
                    MessageError.invoke(e.message!!)
                }
            })

    }
    fun SelectUser(
        userId: String,
        dataResponse: (ResponseProfile) -> Unit,
        MessageError: (String) -> Unit
    ) {
        mDisposable =
            DataModule.myAppService.doGetProfile(BodyProfile(userId))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<ResponseProfile>() {

                    override fun onComplete() {

                    }

                    override fun onNext(response: ResponseProfile) {
                        Log.d("messageInsert", response.toString())
                        dataResponse.invoke(response)

                    }

                    override fun onError(e: Throwable) {
                        Log.d("messageInsert", e.message!!.toString())
                        MessageError.invoke(e.message!!)
                    }
                })

    }

    fun DeleteNotiPersenterRx(
        id: Int,
        datarResponse: (ResponseGetNoti) -> Unit,
        MessageError: (String) -> Unit
    ) {
        mDisposable = DataModule.myAppService.doDelete(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ResponseGetNoti>() {

                override fun onComplete() {

                }

                override fun onNext(response: ResponseGetNoti) {
                    Log.d("messagedeletedata", response.toString())
                    datarResponse.invoke(response)

                }

                override fun onError(e: Throwable) {
                    Log.d("messagegetdata", e.message)
                    MessageError.invoke(e.message!!)
                }
            })

    }

    fun GetImageNotiRx(
        notic_id: String,
        datarResponse: (ResponseGetImageNoti) -> Unit,
        MessageError: (String) -> Unit
    ) {
        mDisposable = DataModule.myAppService.dogetimage(notic_id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ResponseGetImageNoti>() {

                override fun onComplete() {

                }

                override fun onNext(response: ResponseGetImageNoti) {
                    Log.d("messagegetimagenoti", response.toString())
                    datarResponse.invoke(response)

                }

                override fun onError(e: Throwable) {
                    MessageError.invoke(e.message!!)
                }
            })

    }

    fun GetlocationRx(

        datarResponse: (ResponseLocation) -> Unit,
        MessageError: (String) -> Unit
    ) {
        mDisposable = DataModule.myAppService.dogetlocation()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ResponseLocation>() {

                override fun onComplete() {

                }

                override fun onNext(response: ResponseLocation) {
                    Log.d("messagegetimagenoti", response.toString())
                    datarResponse.invoke(response)

                }

                override fun onError(e: Throwable) {
                    MessageError.invoke(e.message!!)
                }
            })

    }
}