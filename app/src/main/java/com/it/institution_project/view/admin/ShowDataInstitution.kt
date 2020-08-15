package com.it.institution_project.view.admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.it.institution_project.R
import com.it.institution_project.model.response.MessageGetInstitution
import com.it.institution_project.model.response.MessageGetUser
import com.it.institution_project.model.response.ResponseGetInstitution
import com.it.institution_project.model.response.ResponseGetUser
import com.it.institution_project.view.admin.adaptershowdata.AdapterShowInstitution
import com.it.institution_project.view.admin.adaptershowdata.AdapterShowUser
import com.it.institution_project.view.main.presentermain.PresenterMain
import kotlinx.android.synthetic.main.activity_show_data_institution.*
import kotlinx.android.synthetic.main.activity_show_data_user.*

class ShowDataInstitution : AppCompatActivity() {

    var mNotiPersenter = PresenterMain()
    var nResponsenoti = ArrayList<MessageGetInstitution>()
    lateinit var notiAdapterData: AdapterShowInstitution

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_data_institution)
        setadapter()
        setapi()

        btn_back_Manage3Admin.setOnClickListener {
            finish()
        }

    }

    private fun setadapter() {
        notiAdapterData =
            AdapterShowInstitution(this, nResponsenoti)
        rcv_showInstitution.apply {
            layoutManager = LinearLayoutManager(this@ShowDataInstitution)
            adapter = notiAdapterData
            notiAdapterData.notifyDataSetChanged()
        }


    }

    private fun setapi() {

        mNotiPersenter.GetDataInstitutionRx(

            this::onSuccessSub,
            this::onErrorSub
        )


    }


    private fun onSuccessSub(response: ResponseGetInstitution) {
        nResponsenoti.clear()
        for (i in response.message.indices) {
            nResponsenoti.add(response.message[i])
        }
        notiAdapterData.Updatedata(nResponsenoti)


    }

    private fun onErrorSub(message: String) {


    }
}