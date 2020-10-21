package com.it.institution_project.ui.check

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.it.institution_project.R
import com.it.institution_project.rest.local.Preferrences
import com.it.institution_project.rest.local.Preferrences.Companion.FILENAME
import com.it.institution_project.ui.notifications.responsenoti.DataList
import com.it.institution_project.ui.notifications.responsenoti.ResponseGetNoti

import com.it.institution_project.view.adapter.AdapterDataNoti
import com.it.institution_project.view.adapter.AdapterHelp
import com.it.institution_project.view.help.HelpActivity
import com.it.institution_project.view.main.CheckNotiActivity
import com.it.institution_project.view.main.presentermain.PresenterMain
import com.it.institution_project.view.showdatanoti.ShowDataNoti
import kotlinx.android.synthetic.main.fragment_notifications.view.*

class Check : Fragment() {

    var mPreferrences = context?.let { Preferrences(it) }
    val mHelpPersenter = PresenterMain()
    val mResponsenoti = ArrayList<DataList>()

    lateinit var helpadapter: AdapterHelp
    lateinit var pref: SharedPreferences
    var tambon = ""
    var insLoca = ""
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        pref = context?.getSharedPreferences(FILENAME, Context.MODE_PRIVATE)!!

        tambon = pref.getString("ins_locality", "") ?: ""
        val view = inflater.inflate(R.layout.fragment_check, container, false)

        startActivity(Intent(context, CheckNotiActivity::class.java))
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setadapter(view)
        setapi()

    }


    private fun setadapter(view: View) {
        helpadapter =
            AdapterHelp(
                requireContext(),
                mResponsenoti
            ) { notic_id, user_id, notic_topic, notic_detail,
                notic_type, notic_voilent, notic_amphur,notic_tambon, notic_status, notic_steps, notic_lat, notic_long, notic_time ->
                val i = Intent(context, CheckActivity::class.java)
                i.putExtra("notic_id", notic_id)
                i.putExtra("user_id", user_id)
                i.putExtra("notic_topic", notic_topic)
                i.putExtra("notic_detail", notic_detail)
                i.putExtra("notic_type", notic_type)
                i.putExtra("notic_voilent", notic_voilent)
                i.putExtra("notic_location", notic_amphur)
                i.putExtra("notic_tambon", notic_tambon)
                i.putExtra("notic_status", notic_status)
                i.putExtra("notic_steps", notic_steps)
                i.putExtra("notic_lat", notic_lat)
                i.putExtra("notic_long", notic_long)
                i.putExtra("notic_time", notic_time)
                startActivity(i)
            }
        view.rcv_help.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = helpadapter
            helpadapter.notifyDataSetChanged()
        }


    }

    private fun setapi() {

        val status = ""
        mHelpPersenter.GetDataNotiRx(
            status,
            tambon,
            this::onSuccessSub,
            this::onErrorSub
        )


    }


    private fun onSuccessSub(response: ResponseGetNoti) {
        mResponsenoti.clear()
        for (i in response.data.indices) {
            mResponsenoti.add(response.data[i])
        }
        helpadapter.Updatedata(mResponsenoti)
    }

    private fun onErrorSub(message: String) {


    }
}