package com.it.institution_project.view.help

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.it.institution_project.R
import com.it.institution_project.mapapi.MapsActivity
import com.it.institution_project.ui.notifications.PresenterNoti
import com.it.institution_project.ui.notifications.responsenoti.ResponseUpdatenoti
import com.it.institution_project.view.adapter.ImageViewPagerNotiAdapter
import com.it.institution_project.view.main.MainActivity
import com.it.institution_project.view.main.presentermain.PresenterMain
import com.viewpagerindicator.CirclePageIndicator
import kotlinx.android.synthetic.main.activity_help.*
import kotlinx.android.synthetic.main.activity_help.viewpager_Show

class HelpActivity : AppCompatActivity() {

    var mnotiPersenter = PresenterMain()
    val mUpdatePersenter = PresenterNoti()
    private var imageViewPagerAdapter: ImageViewPagerNotiAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)

        setapi()

        btn_back_detallhelp.setOnClickListener {
            finish()
        }

        map_location.setOnClickListener {
            val lat:String = intent.getStringExtra("notic_lat")
            val long:String = intent.getStringExtra("notic_long")
            val i = Intent(this,MapsActivity::class.java)
            i.putExtra("notic_lat", lat)
            i.putExtra("notic_long", long)
            startActivity(i)
        }



        val spinner: Spinner = findViewById(R.id.planets_spinner)
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.planets_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
        val notic_id = intent.getStringExtra("notic_id")
//        val notic_id = intent.getIntExtra("notic_id",0)
        val topic:String = intent.getStringExtra("notic_topic")
        val detail:String = intent.getStringExtra("notic_detail")
        val type:String = intent.getStringExtra("notic_type")
        val voilent:String = intent.getStringExtra("notic_voilent")
        val location:String = intent.getStringExtra("notic_location")
        val status:String = intent.getStringExtra("notic_status")
        val steps:String = intent.getStringExtra("notic_steps")
        val notic_tambon:String = intent.getStringExtra("notic_tambon")
//        val long:String = intent.getStringExtra("notic_long")
        val time:String = intent.getStringExtra("notic_time")

        Helptopic.text = topic
        Helptype.text = type
        Helpleval.text = voilent
        Helpdetail.text = detail
        Helplacation.text = location
        Helpdetailhelp.setText(steps)
        Help_tambon.text = notic_tambon
//        lat_location.setText(lat)
//        long_location.setText(long)

//        TV_LatShow.text = lat
//        TV_LongtShow.text = long
//        TV_TimetShow.text = time

        btnEditSave.setOnClickListener {

            mUpdatePersenter.UpdateUserPersenterRx(notic_id,
                planets_spinner.selectedItem.toString(),
                Helpdetailhelp.text.toString(),
                this::onSuccessSubscride,
                this::onErrorSubscribe)

        }
    }
    private fun onSuccessSubscride(response:ResponseUpdatenoti) {
        val user_id = intent.getStringExtra("user_id")
        val notic_id = intent.getStringExtra("notic_id")
        mnotiPersenter.CheckNotiRx(
            user_id,
            planets_spinner.selectedItem.toString(),
            "ผู้ใช้ทั่วไป",

            {
                Toast.makeText(this, "บันทึกข้อมูลเรียบร้อย", Toast.LENGTH_SHORT).show()
            },
            {

            }
        )

        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }
    private fun onErrorSubscribe(message:String){

    }
    private fun setapi() {
//        val notic_id = intent.getStringExtra("notic_id")
        val notic_id = intent.getStringExtra("notic_id")

        mnotiPersenter.GetImageNotiRx(notic_id,

            {

                val viewPager = findViewById<ViewPager>(R.id.viewpager_Show)
                val photos = ArrayList<String>()
                for (i in it.message){
                    photos.add(i.img_normal)
                }
                imageViewPagerAdapter =
                    ImageViewPagerNotiAdapter(this@HelpActivity, photos)
                viewpager_Show.adapter = imageViewPagerAdapter

                val indicator = findViewById<CirclePageIndicator>(R.id.indicator).also {
                    it.setViewPager(viewPager)
                }
                val density = resources.displayMetrics.density
                indicator.radius = 5 * density
            },
            {

            }
        )


    }

}


