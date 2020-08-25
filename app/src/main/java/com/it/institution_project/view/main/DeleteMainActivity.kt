package com.it.institution_project.view.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.it.institution_project.R
import com.it.institution_project.ui.notifications.responsenoti.ResponseGetNoti
import com.it.institution_project.view.main.presentermain.PresenterMain
import kotlinx.android.synthetic.main.activity_delete_main.*

class DeleteMainActivity : AppCompatActivity() {
    val mMainPersenter = PresenterMain()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_main)
        setapi()

        cancel_Delete.setOnClickListener {
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }

    }

    private fun setapi() {

            val id = intent.getIntExtra("id", 0)

            mMainPersenter.DeleteNotiPersenterRx(id,
                this::onSuccessSubscribe,
                this::onErrorSubscribe)

        finish()

    }



    private fun onSuccessSubscribe(responseData: ResponseGetNoti) {

    }

    private fun onErrorSubscribe(message:String) {

    }
}