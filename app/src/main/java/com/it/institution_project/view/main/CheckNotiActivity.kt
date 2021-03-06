package com.it.institution_project.view.main

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.it.institution_project.R
import com.it.institution_project.rest.local.Preferrences
import com.it.institution_project.ui.check.Check
import com.it.institution_project.ui.check.CheckActivity
import com.it.institution_project.view.help.HelpActivity
import com.it.institution_project.view.main.presentermain.PresenterMain

class CheckNotiActivity : AppCompatActivity() {

    lateinit var mPreferrences : Preferrences
    val checknoti = PresenterMain()
    val deleteCheck = PresenterMain()
    lateinit var notificationManager : NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var Builer: Notification.Builder
    private val ChannelID = "com.example.join_sport_app.ui.home"
    private val description = "notification Join Sport"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        setapi()
    }

    private fun setapi() {
       mPreferrences = Preferrences(this)
        val status = "หน่วยงาน"
        checknoti.GetCheckNoti(
            mPreferrences.getInsLocality().toString(),
            status,
            {
                for (i in it.results.indices){
                showNotificationStadium(it.results[i].message,it.results[i].nt_id,it.results[i].locality)


                    deleteCheck.DeleteCheckPersenterRx(
                        it.results[i].nt_id,
                        {

                        },
                        {

                        }
                    )
                }
            },
            {
                finish()
            })
    }

    private fun showNotificationStadium(message: String, nftId: Int,userID:String){
        val intent = Intent(this, MainActivity::class.java)
//        intent.putExtra("userID",userID)
        val pendingIntent = PendingIntent.getActivity(this,0,intent, PendingIntent.FLAG_UPDATE_CURRENT)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notificationChannel = NotificationChannel(ChannelID,description,NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.GREEN
            notificationChannel.enableVibration(false)
            notificationManager.createNotificationChannel(notificationChannel)
            Builer = Notification.Builder(this,ChannelID)
                .setContentTitle("ศูนย์กลางช่วยเหลือผู้ประเหตุสาธารณภัย")
                .setContentText("มีการเเจ้งเหตุเรื่อง :"+message)
                .setSmallIcon(R.drawable.bell)
//                .setLargeIcon(BitmapFactory.decodeResource(this.resources,R.drawable.stadium))
                .setContentIntent(pendingIntent)

        }
        else{
            Builer = Notification.Builder(this)
                .setContentTitle("ศูนย์กลางช่วยเหลือผู้ประเหตุสาธารณภัย")
                .setContentText("มีการเเจ้งเหตุเรื่อง :"+message)
                .setSmallIcon(R.drawable.bell)
//                .setLargeIcon(BitmapFactory.decodeResource(this.resources,R.drawable.stadium))
                .setContentIntent(pendingIntent)
        }
        notificationManager.notify(1000,Builer.build())
//        setAPINotificationDelete(nftId)\
        finish()
    }
}

