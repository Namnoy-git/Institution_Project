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
import com.it.institution_project.ui.notifications.responsenoti.DataList
import com.it.institution_project.ui.notifications.responsenoti.DataReport
import com.it.institution_project.view.main.presentermain.PresenterMain
import kotlinx.android.synthetic.main.activity_report.*
import java.util.*
import kotlin.collections.ArrayList

class ReportActivity : AppCompatActivity() {

    var mdataJanuary = ArrayList<DataReport>()
    var mdataFebruary = ArrayList<DataReport>()
    var mdataMarch = ArrayList<DataReport>()
    var mdataApril = ArrayList<DataReport>()
    var mdataMay = ArrayList<DataReport>()
    var mdataJune = ArrayList<DataReport>()
    var mdataJuly = ArrayList<DataReport>()
    var mdataAugust = ArrayList<DataReport>()
    var mdataSeptember = ArrayList<DataReport>()
    var mdataOctober = ArrayList<DataReport>()
    var mdataNovember = ArrayList<DataReport>()
    var mdataDecember = ArrayList<DataReport>()

    var mNotiPersenter = PresenterMain()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)
        setapi()

        btn_back_Report.setOnClickListener {
            finish()
        }
    }

    private fun initview() {
        val barChart = findViewById<View>(R.id.barchart) as BarChart
        val entries = ArrayList<BarEntry>()
        entries.add(BarEntry(mdataJanuary.size.toFloat(), 0))
        entries.add(BarEntry(mdataFebruary.size.toFloat(), 1))
        entries.add(BarEntry(mdataMarch.size.toFloat(), 2))
        entries.add(BarEntry(mdataApril.size.toFloat(), 3))
        entries.add(BarEntry(mdataMay.size.toFloat(), 4))
        entries.add(BarEntry(mdataJune.size.toFloat(), 5))
        entries.add(BarEntry(mdataJuly.size.toFloat(), 6))
        entries.add(BarEntry(mdataAugust.size.toFloat(), 7))
        entries.add(BarEntry(mdataSeptember.size.toFloat(), 8))
        entries.add(BarEntry(mdataOctober.size.toFloat(), 9))
        entries.add(BarEntry(mdataNovember.size.toFloat(), 10))
        entries.add(BarEntry(mdataDecember.size.toFloat(), 11))

        val bardataset = BarDataSet(entries, "Cells")

        val labels = ArrayList<String>()
        labels.add("สิงหาคม")
        labels.add("กันยายน")
        labels.add("ตุลาคม")
        labels.add("พฤศจิกายน")
        labels.add("ธันวาคม")
        labels.add("มกราคม")
        labels.add("กุมพาพันธ์ุ")
        labels.add("มีนาคม")
        labels.add("เมษายน")
        labels.add("พฤษภาคม")
        labels.add("มิถุนายน")
        labels.add("กรกฎาคม")

        val data = BarData(labels, bardataset)
        barChart.data = data // set the data and list of labels into chart
        barChart.setDescription("Set Bar Chart Description Here") // set the description
        bardataset.setColors(ColorTemplate.COLORFUL_COLORS)
        barChart.animateY(5000)
    }

    private fun setapi() {

        mNotiPersenter.GetTimeReportAdminRx(
            "2020-08%",
            {
                for (i in it.message.indices) {
                    mdataJanuary.add(it.message[i])
                }
                mNotiPersenter.GetTimeReportAdminRx(
                    "2020-09%",
                    {
                        for (i in it.message.indices) {
                            mdataFebruary.add(it.message[i])
                        }
                        mNotiPersenter.GetTimeReportAdminRx(
                            "2020-10%",
                            {
                                for (i in it.message.indices) {
                                    mdataMarch.add(it.message[i])
                                }
                                mNotiPersenter.GetTimeReportAdminRx(
                                    "2020-11%",
                                    {
                                        for (i in it.message.indices) {
                                            mdataApril.add(it.message[i])
                                        }
                                        mNotiPersenter.GetTimeReportAdminRx(
                                            "2020-12%",
                                            {
                                                for (i in it.message.indices) {
                                                    mdataMay.add(it.message[i])

                                                }
                                                mNotiPersenter.GetTimeReportAdminRx(
                                                    "2021-01%",
                                                    {
                                                        for (i in it.message.indices) {
                                                            mdataJune.add(it.message[i])

                                                        }
                                                        mNotiPersenter.GetTimeReportAdminRx(
                                                            "2021-02%",
                                                            {
                                                                for (i in it.message.indices) {
                                                                    mdataJuly.add(it.message[i])
                                                                }
                                                                mNotiPersenter.GetTimeReportAdminRx(
                                                                    "2021-03%",
                                                                    {
                                                                        for (i in it.message.indices) {
                                                                            mdataAugust.add(it.message[i])

                                                                        }

                                                                        mNotiPersenter.GetTimeReportAdminRx(
                                                                            "2021-04%",
                                                                            {
                                                                                for (i in it.message.indices) {
                                                                                    mdataSeptember.add(
                                                                                        it.message[i]
                                                                                    )

                                                                                }

                                                                                mNotiPersenter.GetTimeReportAdminRx(
                                                                                    "2021-05%",
                                                                                    {
                                                                                        for (i in it.message.indices) {
                                                                                            mdataOctober.add(
                                                                                                it.message[i]
                                                                                            )

                                                                                        }

                                                                                        mNotiPersenter.GetTimeReportAdminRx(
                                                                                            "2021-06%",
                                                                                            {
                                                                                                for (i in it.message.indices) {
                                                                                                    mdataNovember.add(
                                                                                                        it.message[i]
                                                                                                    )

                                                                                                }

                                                                                                mNotiPersenter.GetTimeReportAdminRx(
                                                                                                    "2021-07%",
                                                                                                    {
                                                                                                        for (i in it.message.indices) {
                                                                                                            mdataDecember.add(
                                                                                                                it.message[i]
                                                                                                            )
                                                                                                        }
                                                                                                        initview()
                                                                                                    },
                                                                                                    {

                                                                                                    }
                                                                                                )
                                                                                            },
                                                                                            {

                                                                                            }
                                                                                        )
                                                                                    },
                                                                                    {

                                                                                    }
                                                                                )
                                                                            },
                                                                            {

                                                                            }
                                                                        )
                                                                    },
                                                                    {

                                                                    }
                                                                )
                                                            },
                                                            {

                                                            }
                                                        )
                                                    },
                                                    {

                                                    }
                                                )
                                            },
                                            {

                                            }
                                        )
                                    },
                                    {

                                    }
                                )
                            },
                            {

                            }
                        )
                    },
                    {

                    }
                )

            },
            {

            }
        )

    }
}