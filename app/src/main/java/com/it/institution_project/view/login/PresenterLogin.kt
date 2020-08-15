package com.it.institution_project.view.login

import android.util.Log
import com.it.institution_project.rest.DataModule
import com.it.institution_project.view.login.bodylogin.BodyLogin
import com.it.institution_project.view.login.responselogin.ResponseLogin
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class PresenterLogin {

    var mDisposable: Disposable? = null



    fun LoginPersenterRx(
        user:String, pass:String,
        datarResponse:(ResponseLogin)->Unit,
        MessageError:(String)->Unit
    ){
        mDisposable = DataModule.myAppService.doLogin(BodyLogin(user,pass))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ResponseLogin>(){

                override fun onComplete() {

                }

                override fun onNext(responselogin: ResponseLogin) {
                    Log.d("messageLogin",responselogin.toString())
                    datarResponse.invoke(responselogin)

                }

                override fun onError(e: Throwable) {
                    Log.d("messageLogin",e.message)
                    MessageError.invoke(e.message!!)
                }
            })

    }
}