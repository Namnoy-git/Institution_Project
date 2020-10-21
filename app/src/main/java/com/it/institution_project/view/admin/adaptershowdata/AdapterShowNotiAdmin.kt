package com.it.institution_project.view.admin.adaptershowdata

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.it.institution_project.R
import com.it.institution_project.controller.Utils
import com.it.institution_project.rest.BaseUrl
import com.it.institution_project.ui.notifications.responsenoti.DataList


import com.it.institution_project.view.main.DeleteMainActivity
import com.it.institution_project.view.main.presentermain.PresenterMain
import com.squareup.picasso.Picasso
import java.io.File

class AdapterShowNotiAdmin(

    private var context: Context,
    private var notiData: ArrayList<DataList>,
//    private var profileuser : ArrayList<ResponseProfileBody>,
//    private var seeuser : ArrayList<ResponseProfileBody>,
//    private var mData : ArrayList<DeleteData>,
    private var mInvork: (String, String, String, String, String, String, String, String, String, String, String,String) -> (Unit)

) : RecyclerView.Adapter<AdapterShowNotiAdmin.ViewHolder>() {

    val selectProfile = PresenterMain()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.itemdatanoti,
                parent,
                false

            )
        )
    }


    override fun getItemCount() = notiData.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Picasso.get()
            .load(Utils.BaseUrl + "/uploads/" + notiData[position].img)
//            .load("$BaseUrl http://192.168.1.5:4000/uploads/Screenshot_20200717-143414.png")
//            .load(flie)

            .into(holder.imagDetail)

        Picasso.get()
            .load(Utils.BaseUrl + "/uploadregis/" + notiData[position].userimg)
            .into(holder.userimg)
//
        holder.TV_phone.text = notiData[position].phone
        holder.nameuser.text = notiData[position].username
        holder.level.text = notiData[position].notic_voilent
        holder.topic.text = notiData[position].notic_topic
        holder.status.text = notiData[position].notic_status
        holder.time.text = notiData[position].notic_time
//        holder.userid.text = notiData[position].user_id.toString()

        holder.itemView.setOnClickListener {
            mInvork.invoke(
                notiData[position].notic_id.toString(),
                notiData[position].notic_topic,
                notiData[position].notic_detail,
                notiData[position].notic_type,
                notiData[position].notic_voilent,
                notiData[position].notic_amphur,
                notiData[position].notic_tambon,
                notiData[position].notic_status,
                notiData[position].notic_steps,
                notiData[position].notic_lat,
                notiData[position].notic_long,
                notiData[position].notic_time
//                notiData[position].phone

            )
        }

    }


    class ViewHolder(itemsView: View) : RecyclerView.ViewHolder(itemsView) {

        val topic: TextView = itemsView.findViewById<TextView>(R.id.TV_topic)

        val status: TextView = itemsView.findViewById<TextView>(R.id.TV_Detailstatus)
        val time: TextView = itemsView.findViewById<TextView>(R.id.TV_Time)
        val imagDetail: ImageView = itemsView.findViewById<ImageView>(R.id.ImView)
        val level: TextView = itemsView.findViewById<TextView>(R.id.TV_Level)
        val nameuser: TextView = itemsView.findViewById<TextView>(R.id.TV_nameUser)
        val userimg: ImageView = itemsView.findViewById(R.id.ImViewProfileUser)
        val TV_phone : TextView = itemsView.findViewById(R.id.TV_phone)

    }

    fun Updatedata(notiData: ArrayList<DataList>) {
        this.notiData = notiData
        notifyDataSetChanged()
    }

}