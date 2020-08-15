package com.it.institution_project.view.admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.it.institution_project.R
import com.it.institution_project.model.response.MessageGetUser
import com.it.institution_project.model.response.ResponseGetUser
import com.it.institution_project.ui.notifications.responsenoti.ResponseGetNoti
import com.it.institution_project.view.admin.adaptershowdata.AdapterShowUser
import com.it.institution_project.view.main.presentermain.PresenterMain
import kotlinx.android.synthetic.main.activity_show_data_noti_admin.*
import kotlinx.android.synthetic.main.activity_show_data_user.*

class ShowDataUser : AppCompatActivity() {

    var mNotiPersenter = PresenterMain()
    var nResponsenoti = ArrayList<MessageGetUser>()
    lateinit var notiAdapterData: AdapterShowUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_data_user)
        setadapter()
        setapi()

            btn_back_Manage2Admin.setOnClickListener {
                finish()
            }
    }

    private fun setadapter() {
        notiAdapterData =
            AdapterShowUser(this, nResponsenoti)
        rcv_showUser.apply {
            layoutManager = LinearLayoutManager(this@ShowDataUser)
            adapter = notiAdapterData
            notiAdapterData.notifyDataSetChanged()
        }


    }

    private fun setapi() {

        mNotiPersenter.GetDataUserAll(

            this::onSuccessSub,
            this::onErrorSub
        )


    }


    private fun onSuccessSub(response: ResponseGetUser) {
        nResponsenoti.clear()
        for (i in response.message.indices) {
            nResponsenoti.add(response.message[i])
        }
        notiAdapterData.Updatedata(nResponsenoti)


    }

    private fun onErrorSub(message: String) {


    }
}