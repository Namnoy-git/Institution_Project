package com.it.institution_project.view.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.it.institution_project.R
import kotlinx.android.synthetic.main.activity_manage.*

class ManageUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage)

        User_manage.setOnClickListener {
            val i = Intent(this,ShowDataUser::class.java)
            startActivity(i)
        }

        ins_manage.setOnClickListener {
            val i = Intent(this,ShowDataInstitution::class.java)
            startActivity(i)
        }

        btn_back_ManageAdmin.setOnClickListener {
            finish()
        }
    }
}