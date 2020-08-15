package com.it.institution_project.view.admin.adaptershowdata

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.it.institution_project.R
import com.it.institution_project.controller.Utils
import com.it.institution_project.model.response.MessageGetInstitution
import com.it.institution_project.model.response.MessageGetUser
import com.it.institution_project.view.admin.DeleteInstitutionActivity
import com.it.institution_project.view.admin.DeleteUserActivity
import com.it.institution_project.view.main.presentermain.PresenterMain
import com.squareup.picasso.Picasso

class AdapterShowInstitution(

    private var context: Context,
    private var notiData: ArrayList<MessageGetInstitution>
//    private var profileuser : ArrayList<ResponseProfileBody>,
//    private var seeuser : ArrayList<ResponseProfileBody>,
//    private var mData : ArrayList<DeleteData>,


) : RecyclerView.Adapter<AdapterShowInstitution.ViewHolder>() {

    val selectProfile = PresenterMain()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_department,
                parent,
                false

            )
        )
    }


    override fun getItemCount() = notiData.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Picasso.get()
            .load(Utils.BaseUrl + "/uploadregis/unnamed.jpg")

            .into(holder.imagDetail)
//        val bitmap = BitmapFactory.decodeFile(flie.absolutePath)
//        holder.imagDetail.setImageBitmap(bitmap)

        holder.amphur.text = notiData[position].ins_district
        holder.username.text = notiData[position].ins_name
        holder.tambon.text = notiData[position].ins_locality

        holder.itemView.setOnLongClickListener {

            val builderSingle = AlertDialog.Builder(context)
            val animals = arrayOf("ลบ")
            builderSingle.setItems(animals) { _, which ->
                when (which) {


                    0 // ลบข้อมูล
                    -> {
                        val i = Intent(context, DeleteInstitutionActivity::class.java)
                        i.putExtra("id", notiData[position].ins_id)
                        context.startActivity(i)
                    }
                }
            }
            builderSingle.show()
            true

        }


    }


    class ViewHolder(itemsView: View) : RecyclerView.ViewHolder(itemsView) {


        val username: TextView = itemsView.findViewById<TextView>(R.id.username)
        val imagDetail: ImageView = itemsView.findViewById<ImageView>(R.id.img_institution)
        val tambon: TextView = itemsView.findViewById<TextView>(R.id.tambon)
        val amphur : TextView = itemsView.findViewById(R.id.amphur)

    }

    fun Updatedata(notiData: ArrayList<MessageGetInstitution>) {
        this.notiData = notiData
        notifyDataSetChanged()
    }

}