package com.it.institution_project.view.main.presentermain

import android.util.Log
import com.it.institution_project.model.body.*
import com.it.institution_project.model.response.*
import com.it.institution_project.rest.DataModule
import com.it.institution_project.ui.notifications.responsenoti.ResponseGetImageNoti
import com.it.institution_project.ui.notifications.responsenoti.ResponseGetNoti
import com.it.institution_project.ui.notifications.responsenoti.ResponseTimeReport
import com.it.institution_project.view.profileinstitution.UpdateProfileIns
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class PresenterMain {

    var mDisposable: Disposable? = null

    fun GetDataNotiRx(
        notic_status: String,
        datarResponse: (ResponseGetNoti) -> Unit,
        MessageError: (String) -> Unit
    ) {
        mDisposable = DataModule.myAppService.doget(BodyShowStatus(notic_status))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ResponseGetNoti>() {

                override fun onComplete() {

                }

                override fun onNext(response: ResponseGetNoti) {
                    Log.d("messageget", response.toString())
                    datarResponse.invoke(response)

                }

                override fun onError(e: Throwable) {
                    Log.d("messageget", e.message)
                    MessageError.invoke(e.message!!)
                }
            })

    }

    fun GetDataNotiAdminRx(

        datarResponse: (ResponseGetNoti) -> Unit,
        MessageError: (String) -> Unit
    ) {
        mDisposable = DataModule.myAppService.dogetnotiAdmin()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ResponseGetNoti>() {

                override fun onComplete() {

                }

                override fun onNext(response: ResponseGetNoti) {
                    Log.d("messageget", response.toString())
                    datarResponse.invoke(response)

                }

                override fun onError(e: Throwable) {
                    Log.d("messageget", e.message)
                    MessageError.invoke(e.message!!)
                }
            })

    }

    fun GetTimeReportAdminRx(
        timeRep : String,
        datarResponse: (ResponseTimeReport) -> Unit,
        MessageError: (String) -> Unit
    ) {
        mDisposable = DataModule.myAppService.dogetReport(BodyTimeReport(timeRep))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ResponseTimeReport>() {

                override fun onComplete() {

                }

                override fun onNext(response: ResponseTimeReport) {
                    Log.d("messagegettime", response.toString())
                    datarResponse.invoke(response)

                }

                override fun onError(e: Throwable) {
                    Log.d("messagegettime", e.message)
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

    fun DeleteUserPersenterRx(
        id: Int,
        datarResponse: (ResponseGetNoti) -> Unit,
        MessageError: (String) -> Unit
    ) {
        mDisposable = DataModule.myAppService.doDeleteUser(id)
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

    fun DeleteInstitutionRx(
        id: Int,
        datarResponse: (ResponseGetInstitution) -> Unit,
        MessageError: (String) -> Unit
    ) {
        mDisposable = DataModule.myAppService.doDeleteinsti(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ResponseGetInstitution>() {

                override fun onComplete() {

                }

                override fun onNext(response: ResponseGetInstitution) {
                    Log.d("messagedeletedatains", response.toString())
                    datarResponse.invoke(response)

                }

                override fun onError(e: Throwable) {
                    Log.d("messagegetdatains", e.message)
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

    fun InsertAdminRx(
        name: String,
        district: String,
        locality: String,
        phone: String,
        username: String,
        password: String,
        datarResponse: (ResponseInsertAdmin) -> Unit,
        MessageError: (String) -> Unit
    ) {
        mDisposable = DataModule.myAppService.doPostAdmin(
            BodyInsertAdmin(
                name,
                district,
                locality,
                phone,
                username,
                password
            )
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ResponseInsertAdmin>() {

                override fun onComplete() {

                }

                override fun onNext(response: ResponseInsertAdmin) {
                    Log.d("messageLogin", response.toString())
                    datarResponse.invoke(response)

                }

                override fun onError(e: Throwable) {
                    Log.d("messageLogin", e.message)
                    MessageError.invoke(e.message!!)
                }
            })

    }

    fun GetDataTambon(

        datarResponse: (ResponseGetTambon) -> Unit,
        MessageError: (String) -> Unit
    ) {
        mDisposable = DataModule.myAppService.doGetTambon()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ResponseGetTambon>() {

                override fun onComplete() {

                }

                override fun onNext(response: ResponseGetTambon) {
                    Log.d("messageget", response.toString())
                    datarResponse.invoke(response)

                }

                override fun onError(e: Throwable) {
                    Log.d("messageget", e.message)
                    MessageError.invoke(e.message!!)
                }
            })

    }

    fun GetDataAmphur(

        datarResponse: (ResponseGetAmphur) -> Unit,
        MessageError: (String) -> Unit
    ) {
        mDisposable = DataModule.myAppService.doGetAmphur()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ResponseGetAmphur>() {

                override fun onComplete() {

                }

                override fun onNext(response: ResponseGetAmphur) {
                    Log.d("messageget", response.toString())
                    datarResponse.invoke(response)

                }

                override fun onError(e: Throwable) {
                    Log.d("messageget", e.message)
                    MessageError.invoke(e.message!!)
                }
            })

    }

    fun GetDataUserAll(

        datarResponse: (ResponseGetUser) -> Unit,
        MessageError: (String) -> Unit
    ) {
        mDisposable = DataModule.myAppService.doGetUser()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ResponseGetUser>() {

                override fun onComplete() {

                }

                override fun onNext(response: ResponseGetUser) {
                    Log.d("messagegetUser", response.toString())
                    datarResponse.invoke(response)

                }

                override fun onError(e: Throwable) {
                    Log.d("messagegetUser", e.message)
                    MessageError.invoke(e.message!!)
                }
            })

    }

    fun GetDataInstitutionRx(

        datarResponse: (ResponseGetInstitution) -> Unit,
        MessageError: (String) -> Unit
    ) {
        mDisposable = DataModule.myAppService.doGetInstitution()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ResponseGetInstitution>() {

                override fun onComplete() {

                }

                override fun onNext(response: ResponseGetInstitution) {
                    Log.d("messagegetInstitution", response.toString())
                    datarResponse.invoke(response)

                }

                override fun onError(e: Throwable) {
                    Log.d("messagegetInstitution", e.message)
                    MessageError.invoke(e.message!!)
                }
            })

    }

    fun SelectInsProfile(
        ins_id: String,
        dataResponse: (ResponseProfileIns) -> Unit,
        MessageError: (String) -> Unit
    ) {
        mDisposable =
            DataModule.myAppService.doInstitutionProfile(BodyInstiProfile(ins_id))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<ResponseProfileIns>() {

                    override fun onComplete() {

                    }

                    override fun onNext(response: ResponseProfileIns) {
                        Log.d("messageInsert", response.toString())
                        dataResponse.invoke(response)

                    }

                    override fun onError(e: Throwable) {
                        Log.d("messageInsert", e.message!!.toString())
                        MessageError.invoke(e.message!!)
                    }
                })

    }

    fun UpdateProfileInsRx(
        id: String,
        ins_name: String,
        ins_district: String,
        ins_locality: String,
        ins_phone: String,
        ins_username: String,
        ins_password: String,
        datarResponse: (ResponseUpdateProfile) -> Unit,
        MessageError: (String) -> Unit
    ) {
        mDisposable = DataModule.myAppService.doUpdateProfile(id, BodyUpdateProfile(ins_name, ins_district, ins_locality, ins_phone, ins_username, ins_password))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ResponseUpdateProfile>() {

                override fun onComplete() {

                }

                override fun onNext(response: ResponseUpdateProfile) {
                    Log.d("messageUpdate", response.toString())
                    datarResponse.invoke(response)

                }

                override fun onError(e: Throwable) {
                    Log.d("messageUpdate", e.message!!.toString())
                    MessageError.invoke(e.message!!)
                }
            })

    }


}