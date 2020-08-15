package com.it.institution_project.view.admin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.it.institution_project.R
import com.it.institution_project.model.response.ResponseGetInstitution
import com.it.institution_project.ui.notifications.responsenoti.ResponseGetNoti
import com.it.institution_project.view.main.MainActivity
import com.it.institution_project.view.main.presentermain.PresenterMain
import kotlinx.android.synthetic.main.activity_delete_main.*

class DeleteInstitutionActivity : AppCompatActivity() {
    val mMainPersenter = PresenterMain()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_main)
        setapi()


    }

    private fun setapi() {

        val id = intent.getIntExtra("id", 0)

        mMainPersenter.DeleteInstitutionRx(id,
            this::onSuccessSubscribe,
            this::onErrorSubscribe)
        val i = Intent(this, ShowDataUser::class.java)
        startActivity(i)

    }



    private fun onSuccessSubscribe(responseData: ResponseGetInstitution) {

    }

    private fun onErrorSubscribe(message:String) {

    }
}