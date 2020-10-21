package com.it.institution_project.view.profileinstitution

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.it.institution_project.R
import com.it.institution_project.model.response.ResponseUpdateProfile
import com.it.institution_project.rest.local.Preferrences
import com.it.institution_project.view.main.presentermain.PresenterMain
import kotlinx.android.synthetic.main.activity_update_profile_ins.*

class UpdateProfileIns : AppCompatActivity() {

    var mPreferrences = Preferrences(this)
    var mProfilePersenter = PresenterMain()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_profile_ins)
        setapi()


        btnEditCan.setOnClickListener {
            val i = Intent(this, ProfileInstitution::class.java)
            startActivity(i)
            finish()
        }

        btn_back_detallUpdateAdmin.setOnClickListener {
            finish()
        }

        mPreferrences.getInsId() ?: ""
        val name = intent.getStringExtra("ins_name")
        val Amphor = intent.getStringExtra("Ins_Amphor")
        val tambon = intent.getStringExtra("Ins_tambon")
        val phone = intent.getStringExtra("edt_phone")
        val user_name = intent.getStringExtra("edt_user_name")
        val password = intent.getStringExtra("edt_password")


        name_Ins.setText(name)
        amphur_Ins.setText(Amphor)
        tambon_Ins.setText(tambon)
        phone_Ins.setText(phone)
        username_Ins.setText(user_name)
        password_Ins.setText(password)


    }

    private fun setapi() {
        btnEditSaveIns.setOnClickListener {
            mProfilePersenter.UpdateProfileInsRx(
                mPreferrences.getInsId() ?: "",
                name_Ins.text.toString(),
                amphur_Ins.text.toString(),
                tambon_Ins.text.toString(),
                phone_Ins.text.toString(),
                username_Ins.text.toString(),
                password_Ins.text.toString(),

                {
                    val i = Intent(this,ProfileInstitution::class.java)
                    startActivity(i)
                    finish()

                },
                {

                }
            )
        }

    }


}