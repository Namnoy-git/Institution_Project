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
import com.it.institution_project.model.response.MessageGetUser
import com.it.institution_project.ui.notifications.responsenoti.DataList
import com.it.institution_project.view.admin.DeleteUserActivity
import com.it.institution_project.view.main.DeleteMainActivity
import com.it.institution_project.view.main.presentermain.PresenterMain
import com.squareup.picasso.Picasso

class AdapterShowUser(

    private var context: Context,
    private var notiData: ArrayList<MessageGetUser>
//    private var profileuser : ArrayList<ResponseProfileBody>,
//    private var seeuser : ArrayList<ResponseProfileBody>,
//    private var mData : ArrayList<DeleteData>,


) : RecyclerView.Adapter<AdapterShowUser.ViewHolder>() {

    val selectProfile = PresenterMain()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_user,
                parent,
                false

            )
        )
    }


    override fun getItemCount() = notiData.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Picasso.get()
            .load(Utils.BaseUrl + "/uploadregis/" + notiData[position].user_img)

            .into(holder.imagDetail)
//        val bitmap = BitmapFactory.decodeFile(flie.absolutePath)
//        holder.imagDetail.setImageBitmap(bitmap)

        holder.phone.text = notiData[position].user_phone
        holder.username.text = notiData[position].user_name
        holder.address.text = notiData[position].user_address

        holder.itemView.setOnLongClickListener {

            val builderSingle = AlertDialog.Builder(context)
            val animals = arrayOf("ลบ")
            builderSingle.setItems(animals) { _, which ->
                when (which) {


                    0 // ลบข้อมูล
                    -> {
                        val i = Intent(context, DeleteUserActivity::class.java)
                        i.putExtra("id", notiData[position].user_id)
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
        val imagDetail: ImageView = itemsView.findViewById<ImageView>(R.id.img_User)
        val address: TextView = itemsView.findViewById<TextView>(R.id.address_User)
        val phone : TextView = itemsView.findViewById(R.id.phone_User)

    }

    fun Updatedata(notiData: ArrayList<MessageGetUser>) {
        this.notiData = notiData
        notifyDataSetChanged()
    }

}