package com.it.institution_project.view.profileinstitution

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.it.institution_project.R
import com.it.institution_project.rest.local.Preferrences
import com.it.institution_project.view.main.presentermain.PresenterMain
import kotlinx.android.synthetic.main.activity_profile_institution.*

class ProfileInstitution : AppCompatActivity() {

    var mPreferrences = Preferrences(this)
    var mProfilePersenter = PresenterMain()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_institution)
        setapi()


        btn_back_detallProfileAdmin.setOnClickListener {
            finish()
        }

        btnEditUpdateAdmin.setOnClickListener {
            val i = Intent(this, UpdateProfileIns::class.java)

            mPreferrences.getInsId() ?: ""
            i.putExtra("ins_name", edt_Department.text.toString())
            i.putExtra("Ins_Amphor", Ins_Amphor.text.toString())
            i.putExtra("Ins_tambon", Ins_tambon.text.toString())
            i.putExtra("edt_phone", edt_phone.text.toString())
            i.putExtra("edt_user_name", edt_user_name.text.toString())
            i.putExtra("edt_password", edt_password.text.toString())

            startActivity(i)
            finish()
        }
    }

    private fun setapi() {
        mProfilePersenter.SelectInsProfile(

            mPreferrences.getInsId() ?: "",

            {
                edt_Department.text = it.message.ins_name
                Ins_Amphor.text = it.message.ins_district
                Ins_tambon.text = it.message.ins_locality
                edt_phone.text = it.message.ins_phone
                edt_user_name.text = it.message.ins_username
                edt_password.text = it.message.ins_password

            },
            {

            }
        )

    }
}