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
import java.util.*

class PieChartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pie_chart)
        val pieChart = findViewById<PieChart>(R.id.piechart)
        val entries = ArrayList<BarEntry>()
        entries.add(BarEntry(945f, 0))
        entries.add(BarEntry(1040f, 1))
        entries.add(BarEntry(1133f, 2))
        entries.add(BarEntry(1240f, 3))
        entries.add(BarEntry(1369f, 4))
        entries.add(BarEntry(1487f, 5))
        entries.add(BarEntry(1501f, 6))
        entries.add(BarEntry(1645f, 7))
        entries.add(BarEntry(1578f, 8))
        entries.add(BarEntry(1695f, 9))
        val dataSet = PieDataSet(entries as List<Entry>?, "Number Of Employees")
        val year = ArrayList<String>()
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
    }
}