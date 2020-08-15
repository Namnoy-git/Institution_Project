package com.it.institution_project.view.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.it.institution_project.R
import com.it.institution_project.model.response.ResponseProfileBody
import com.it.institution_project.ui.home.MapsActivityAll
import com.it.institution_project.ui.notifications.responsenoti.DataList
import com.it.institution_project.ui.notifications.responsenoti.ResponseGetNoti
import com.it.institution_project.view.adapter.AdapterDataNoti
import com.it.institution_project.view.admin.adaptershowdata.AdapterShowNotiAdmin
import com.it.institution_project.view.main.presentermain.PresenterMain
import com.it.institution_project.view.showdatanoti.ShowDataNoti
import kotlinx.android.synthetic.main.activity_show_data_noti_admin.*
import kotlinx.android.synthetic.main.fragment_home.view.*


class ShowDataNotiAdmin : AppCompatActivity() {

    var mNotiPersenter = PresenterMain()
    var nResponsenoti = ArrayList<DataList>()
    lateinit var notiAdapterData: AdapterShowNotiAdmin

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_data_noti_admin)
        setadapter()
        setapi()

        btn_back_detallhomeAdmin.setOnClickListener {
            finish()
        }

        Tv_location.setOnClickListener {
            val i = Intent(this, MapsActivityAll::class.java)
            startActivity(i)

        }
    }


    private fun setadapter() {
        notiAdapterData =
            AdapterShowNotiAdmin(this, nResponsenoti) { notic_id, notic_topic, notic_detail,
                                                   notic_type, notic_voilent, notic_amphur, notic_tambon, notic_status, notic_steps, notic_lat, notic_long, notic_time ->
                val i = Intent(this, ShowDataNoti::class.java)
                i.putExtra("notic_id", notic_id)
                i.putExtra("notic_topic", notic_topic)
                i.putExtra("notic_detail", notic_detail)
                i.putExtra("notic_type", notic_type)
                i.putExtra("notic_voilent", notic_voilent)
                i.putExtra("notic_amphur", notic_amphur)
                i.putExtra("notic_tambon", notic_tambon)
                i.putExtra("notic_status", notic_status)
                i.putExtra("notic_steps", notic_steps)
                i.putExtra("notic_lat", notic_lat)
                i.putExtra("notic_long", notic_long)
                i.putExtra("notic_time", notic_time)
                startActivity(i)
            }
        rcv_showadmin.apply {
            layoutManager = LinearLayoutManager(this@ShowDataNotiAdmin)
            adapter = notiAdapterData
            notiAdapterData.notifyDataSetChanged()
        }


    }

    private fun setapi() {

        mNotiPersenter.GetDataNotiAdminRx(

            this::onSuccessSub,
            this::onErrorSub
        )


    }


    private fun onSuccessSub(response: ResponseGetNoti) {
        nResponsenoti.clear()
        for (i in response.data.indices) {
            nResponsenoti.add(response.data[i])
        }
        notiAdapterData.Updatedata(nResponsenoti)


    }

    private fun onErrorSub(message: String) {


    }
}