package com.it.institution_project.view.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.it.institution_project.R
import com.it.institution_project.ui.home.MapsActivityAll
import com.it.institution_project.view.main.presentermain.PresenterMain
import kotlinx.android.synthetic.main.activity_insert_institution.*
import kotlinx.android.synthetic.main.activity_show_data_noti_admin.*
import kotlinx.android.synthetic.main.fragment_home.view.*


class InsertInstitutionActivity : AppCompatActivity() {

    var mNotiPersenter = PresenterMain()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_institution)
        setapi()
        setspinner()

        btn_back_detallInsertAdmin.setOnClickListener {
            finish()
        }


    }

    private fun setspinner() {
        mNotiPersenter.GetDataAmphur(
            {
                val amphur = ArrayList<String>()
                for (i in it.data) {
                    amphur.add(i.amphur_name)
                }
                val adapter =
                    ArrayAdapter(baseContext, android.R.layout.simple_dropdown_item_1line, amphur)
                spinner_Amphor.adapter = adapter
            },
            {

            }
        )
        mNotiPersenter.GetDataTambon(
            {
                val tambon = ArrayList<String>()
                for (i in it.data) {
                    tambon.add(i.tambon_name)
                }
                val adapter =
                    ArrayAdapter(baseContext, android.R.layout.simple_dropdown_item_1line, tambon)
                spinner_tambon.adapter = adapter
            },
            {

            }
        )
    }

    private fun setapi() {
        btnEditSaveAdmin.setOnClickListener {
            mNotiPersenter.InsertAdminRx(

                edt_Department.text.toString(),
                spinner_Amphor.selectedItem.toString(),
                spinner_tambon.selectedItem.toString(),
                edt_phone.text.toString(),
                edt_user_name.text.toString(),
                edt_password.text.toString(),

                {
                    Toast.makeText(this, "บันทึกเรียบร้อยเเล้ว", Toast.LENGTH_SHORT).show()
                    val i = Intent(this, MainAdminActivity::class.java)
                    startActivity(i)
                },
                {

                }
            )

        }
    }

}