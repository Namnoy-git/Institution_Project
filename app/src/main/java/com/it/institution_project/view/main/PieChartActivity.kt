package com.it.institution_project.view.main

import com.it.institution_project.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.utils.ColorTemplate
import com.it.institution_project.ui.notifications.responsenoti.DataList
import com.it.institution_project.view.main.presentermain.PresenterMain
import java.util.*

class PieChartActivity : AppCompatActivity() {

    var mdataReport = ArrayList<DataList>()

    var mNotiPersenter = PresenterMain()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pie_chart)


        mNotiPersenter.GetDataNotiAdminRx(

            {
                for (i in it.data.indices) {
                    mdataReport.add(it.data[i])
                }
                val pieChart = findViewById<PieChart>(R.id.piechart)
                val entries = ArrayList<BarEntry>()
                entries.add(BarEntry(mdataReport.size.toFloat(), 0))
                entries.add(BarEntry(mdataReport.size.toFloat(), 1))
                entries.add(BarEntry(mdataReport.size.toFloat(), 2))
                entries.add(BarEntry(mdataReport.size.toFloat(), 3))
                entries.add(BarEntry(mdataReport.size.toFloat(), 4))
                entries.add(BarEntry(mdataReport.size.toFloat(), 5))
                entries.add(BarEntry(mdataReport.size.toFloat(), 6))
                entries.add(BarEntry(mdataReport.size.toFloat(), 7))
                entries.add(BarEntry(mdataReport.size.toFloat(), 8))
                entries.add(BarEntry(mdataReport.size.toFloat(), 9))


                val dataSet = PieDataSet(entries as List<Entry>?, "Number Of Employees")

                val year = ArrayList<String>()
                for (i in it.data){
                    year.add(i.notic_time)
                }

                year.add("2008")
                year.add("2009")
                year.add("2010")
                year.add("2011")
                year.add("2012")
                year.add("2013")
                year.add("2014")
                year.add("2015")
                year.add("2016")
                year.add("2017")
                val data = PieData(year, dataSet)
                pieChart.data = data
                dataSet.setColors(ColorTemplate.COLORFUL_COLORS)
                pieChart.animateXY(5000, 5000)
            },
            {

            })
    }
}