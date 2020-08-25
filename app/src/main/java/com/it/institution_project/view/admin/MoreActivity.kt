package com.it.institution_project.view.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.it.institution_project.R
import com.it.institution_project.view.login.LoginInstitutionActivity
import com.it.institution_project.view.main.ReportActivity
import kotlinx.android.synthetic.main.activity_more.*

class MoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more)

        btn_back_More.setOnClickListener {
            finish()
        }

        report_admin.setOnClickListener {
            val i = Intent(this,ReportActivity::class.java)
            startActivity(i)

            button_logout_admin.setOnClickListener {
                val i = Intent(this,LoginInstitutionActivity::class.java)
                startActivity(i)
                finish()
            }
        }
    }
}