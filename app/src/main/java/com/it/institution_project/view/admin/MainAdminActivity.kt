package com.it.institution_project.view.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.it.institution_project.R
import kotlinx.android.synthetic.main.activity_main_admin.*

class MainAdminActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_admin)

        AddUser.setOnClickListener {
            val i = Intent(this, InsertInstitutionActivity::class.java)
            startActivity(i)
        }

        DataUser.setOnClickListener {
            val i = Intent(this, ManageUserActivity::class.java)
            startActivity(i)
        }

        Notification.setOnClickListener {
            val i = Intent(this, ShowDataNotiAdmin::class.java)
            startActivity(i)
        }

    }
}