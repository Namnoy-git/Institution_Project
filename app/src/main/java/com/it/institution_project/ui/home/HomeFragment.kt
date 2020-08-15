package com.it.institution_project.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.it.institution_project.R
import com.it.institution_project.model.response.ResponseProfileBody
import com.it.institution_project.ui.notifications.PresenterNoti
import com.it.institution_project.ui.notifications.responsenoti.DataList

import com.it.institution_project.ui.notifications.responsenoti.ResponseGetNoti
import com.it.institution_project.view.adapter.AdapterDataNoti
import com.it.institution_project.view.main.presentermain.PresenterMain
import com.it.institution_project.view.showdatanoti.ShowDataNoti
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    private var CODE = 999
    var mNotiPersenter = PresenterMain()
    var nResponsenoti = ArrayList<DataList>()
    var mprofile = ArrayList<ResponseProfileBody>()
    lateinit var notiAdapterData: AdapterDataNoti

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        view.Tv_location.setOnClickListener {
            val i = Intent(context,MapsActivityAll::class.java)
            startActivity(i)

        }



        return view.rootView
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setadapter(view)
        setapi()

    }


    private fun setadapter(view: View) {
        notiAdapterData =
            AdapterDataNoti(requireContext(), nResponsenoti) { notic_id,notic_topic, notic_detail,
                                                               notic_type, notic_voilent, notic_amphur,notic_tambon, notic_status, notic_steps, notic_lat, notic_long, notic_time ->
                val i = Intent(context, ShowDataNoti::class.java)
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
        view.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = notiAdapterData
            notiAdapterData.notifyDataSetChanged()
        }


    }

    private fun setapi() {
        val staus = "ช่วยเหลือเรียบร้อย"
        mNotiPersenter.GetDataNotiRx(
            staus,
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