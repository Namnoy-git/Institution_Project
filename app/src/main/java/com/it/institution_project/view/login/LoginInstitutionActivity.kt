package com.it.institution_project.view.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.it.institution_project.view.main.MainActivity
import com.it.institution_project.R
import com.it.institution_project.rest.local.Preferrences
import com.it.institution_project.view.login.responselogin.ResponseLogin
import com.it.institution_project.view.admin.MainAdminActivity
import kotlinx.android.synthetic.main.activity_login_institution.*

class LoginInstitutionActivity : AppCompatActivity() {

    var mPreferrences = Preferrences(this)
    var mLoginPersenter = PresenterLogin ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_institution)
        initview()
        btn_Login.setOnClickListener{
            if (edt_username_Login.text.toString()=="Admin"&&edt_Password_Login.text.toString()=="admin123456"){
                val i = Intent(this,
                    MainAdminActivity::class.java)
                startActivity(i)
                finish()

            }else
            {
                setapi()
            }

            }


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
            mLoginPersenter.LoginPersenterRx(
                edt_username_Login.text.toString(),
                edt_Password_Login.text.toString(),
                this::onSuccessSubscrib,
                this::onErrorSubscrib)
    }


    private fun onSuccessSubscrib(responseLogin: ResponseLogin) {

        mPreferrences.saveToken(responseLogin.message.token)
        mPreferrences.saveUserId(responseLogin.message.ins_id.toString())
        mPreferrences.saveLocality(responseLogin.message.ins_locality)
//        Toast.makeText(applicationContext, mPreferrences.getInsLocality(), Toast.LENGTH_SHORT).show()



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