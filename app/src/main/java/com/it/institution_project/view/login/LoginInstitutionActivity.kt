package com.it.institution_project.view.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.it.institution_project.view.main.MainActivity
import com.it.institution_project.R
import com.it.institution_project.rest.local.Preferrences
import com.it.institution_project.view.login.responselogin.ResponseLogin
import kotlinx.android.synthetic.main.activity_login_institution.*

class LoginInstitutionActivity : AppCompatActivity() {

    var mPreferrences = Preferrences(this)
    var mLoginPersenter = PresenterLogin ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_institution)
        initview()
        setapi()





    }

    private fun initview() {
        if (checkIslogin(mPreferrences.getToken())){

//            val user_id = mPreferrences.getUserId()//เอาไปเรียกใช้ได้้ทุกหน้า

            finish()
            val mIntent = Intent(this, MainActivity::class.java)
            startActivity(mIntent)
        }


    }




    private fun setapi() {
        btn_Login.setOnClickListener{

            mLoginPersenter.LoginPersenterRx(
                edt_username_Login.text.toString(),
                edt_Password_Login.text.toString(),
                this::onSuccessSubscrib,
                this::onErrorSubscrib)

        }

    }


    private fun onSuccessSubscrib(responseLogin: ResponseLogin) {

        mPreferrences.saveToken(responseLogin.message.token)
        mPreferrences.saveUserId(responseLogin.message.ins_id.toString())

        val mIntent = Intent(this,
            MainActivity::class.java)

        startActivity(mIntent)
    }

    private fun onErrorSubscrib(Message:String) {

    }

    fun checkIslogin(token:String):Boolean{
        return  token.isNotEmpty()
    }
}