package com.it.institution_project.ui.dashboard

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.it.institution_project.R
import com.it.institution_project.rest.local.Preferrences
import com.it.institution_project.rest.local.Preferrences.Companion.FILENAME
import com.it.institution_project.view.login.LoginInstitutionActivity
import com.it.institution_project.view.main.PieChartActivity
import com.it.institution_project.view.main.ReportActivity
import kotlinx.android.synthetic.main.fragment_dashboard.view.*

class DashboardFragment : Fragment() {


    lateinit var pref: SharedPreferences
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)
        pref = context?.getSharedPreferences(FILENAME, Context.MODE_PRIVATE)!!


        view.button_logout.setOnClickListener {
            clearForLogout()
            val mIntent = Intent(context, LoginInstitutionActivity::class.java)
            startActivity(mIntent)
        }

        view.report.setOnClickListener {
            val i =Intent(context,PieChartActivity::class.java)
            startActivity(i)
        }

        return view
    }


    private fun clearForLogout() {
        val editor = pref.edit()
        editor.putString(Preferrences.TOKEN, "")
        editor.apply()
    }
}