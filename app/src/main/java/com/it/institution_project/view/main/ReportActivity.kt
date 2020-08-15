package com.it.institution_project.view.main
import android.os.Bundle
import com.it.institution_project.R
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate
import java.util.*

class ReportActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)
        val barChart = findViewById<View>(R.id.barchart) as BarChart
        val entries = ArrayList<BarEntry>()
        entries.add(BarEntry(8f, 0))
        entries.add(BarEntry(2f, 1))
        entries.add(BarEntry(5f, 2))
        entries.add(BarEntry(20f, 3))
        entries.add(BarEntry(15f, 4))
        entries.add(BarEntry(19f, 5))
        val bardataset = BarDataSet(entries, "Cells")
        val labels = ArrayList<String>()
        labels.add("2016")
        labels.add("2015")
        labels.add("2014")
        labels.add("2013")
        labels.add("2012")
        labels.add("2011")
        val data = BarData(labels, bardataset)
        barChart.data = data // set the data and list of labels into chart
        barChart.setDescription("Set Bar Chart Description Here") // set the description
        bardataset.setColors(ColorTemplate.COLORFUL_COLORS)
        barChart.animateY(5000)
    }
}