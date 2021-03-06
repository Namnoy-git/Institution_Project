package com.it.institution_project.view.showdatanoti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.it.institution_project.R
import com.it.institution_project.mapapi.MapsActivity
import com.it.institution_project.ui.notifications.responsenoti.ResponseGetImageNoti
import com.it.institution_project.view.adapter.ImageViewPagerNotiAdapter
import com.it.institution_project.view.help.HelpActivity
import com.it.institution_project.view.main.presentermain.PresenterMain
import com.viewpagerindicator.CirclePageIndicator
import kotlinx.android.synthetic.main.activity_show_data_noti.*


@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class ShowDataNoti : AppCompatActivity() {

    var notiPersenter = PresenterMain()
    private var imageViewPagerAdapter: ImageViewPagerNotiAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_data_noti)
        setApi()

        btn_back_detallhome.setOnClickListener {
            finish()
        }

        Map_location_show.setOnClickListener {
            val lat:String = intent.getStringExtra("notic_lat")
            val long:String = intent.getStringExtra("notic_long")
            val i = Intent(this,MapsActivity::class.java)
            i.putExtra("notic_lat", lat)
            i.putExtra("notic_long", long)
            startActivity(i)
        }



        val topic:String = intent.getStringExtra("notic_topic")
        val detail:String = intent.getStringExtra("notic_detail")
        val type:String = intent.getStringExtra("notic_type")
        val voilent:String = intent.getStringExtra("notic_voilent")
        val amphur:String = intent.getStringExtra("notic_amphur")
        val tambon:String = intent.getStringExtra("notic_tambon")
        val status:String = intent.getStringExtra("notic_status")
        val steps:String = intent.getStringExtra("notic_steps")
        val lat:String = intent.getStringExtra("notic_lat")
        val long:String = intent.getStringExtra("notic_long")
        val time:String = intent.getStringExtra("notic_time")


        Showtopic.text = topic
        Showtype.text = type
        Showleval.text = voilent
        Showdetail.text = detail
        Show_amphur.text = amphur
        Show_tambon.text = tambon
        Showhelp.text = status
        Showdetailhelp.text = steps
//        TV_LatShow.text = lat
//        TV_LongtShow.text = long
//        TV_TimetShow.text = time



    }

    private fun setApi(){
        val notic_id = intent.getStringExtra("notic_id")
        notiPersenter.GetImageNotiRx(notic_id,
            this::onSuccessSub,
            this::onErrorSub)
    }
    private fun onErrorSub(e: String) {

    }

    private fun onSuccessSub(res: ResponseGetImageNoti) {
        val photos = ArrayList<String>()
        for (i in res.message){
            photos.add(i.img_normal)
        }
        val viewPager = findViewById<ViewPager>(R.id.viewpager_Show)
        imageViewPagerAdapter =
            ImageViewPagerNotiAdapter(this@ShowDataNoti, photos)
        viewPager.adapter = imageViewPagerAdapter

        val indicator = findViewById<CirclePageIndicator>(R.id.indicator).also {
            it.setViewPager(viewPager)
        }
        val density = resources.displayMetrics.density
        indicator.radius = 5 * density

    }
}
