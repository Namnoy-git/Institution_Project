package com.it.institution_project.ui.notifications

import android.util.Log
import com.it.institution_project.rest.DataModule
import com.it.institution_project.ui.notifications.bodynoti.BodyUpdateNoti
import com.it.institution_project.ui.notifications.responsenoti.ResponseGetNoti
import com.it.institution_project.ui.notifications.responsenoti.ResponseUpdatenoti
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class PresenterNoti {

    var mDisposable: Disposable? = null


    fun UpdateUserPersenterRx(
        notic_id: String,
        status: String,
        steps: String,

        datarResponse: (ResponseUpdatenoti) -> Unit,
        MessageError: (String) -> Unit
    ) {
        mDisposable =
            DataModule.myAppService.UpdateNoti(notic_id, BodyUpdateNoti(status, steps))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<ResponseUpdatenoti>() {

                    override fun onComplete() {

                    }

                    override fun onNext(response: ResponseUpdatenoti) {
                        Log.d("messageupdatestatus", response.toString())
                        datarResponse.invoke(response)

                    }

                    override fun onError(e: Throwable) {
                        Log.d("messageupdatestatus", e.message!!.toString())
                        MessageError.invoke(e.message!!)
                    }
                })

    }

    fun GetNotiPersenterRx(

        datarResponse: (ResponseGetNoti) -> Unit,
        MessageError: (String) -> Unit
    ) {
        mDisposable = DataModule.myAppService.doGetNoti()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ResponseGetNoti>() {

                override fun onComplete() {

                }

                override fun onNext(response: ResponseGetNoti) {
                    Log.d("messagegetnoti", response.toString())
                    datarResponse.invoke(response)

                }

                override fun onError(e: Throwable) {
                    MessageError.invoke(e.message!!)
                }
            })

    }
}