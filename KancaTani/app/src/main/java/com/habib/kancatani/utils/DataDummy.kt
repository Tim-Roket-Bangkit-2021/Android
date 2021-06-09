package com.habib.kancatani.utils

import com.habib.kancatani.data.ChartEntity

object DataDummy {
    fun DummyChart(): ArrayList<ChartEntity> {

        val charts = ArrayList<ChartEntity>()

        charts.add(ChartEntity(1 ,
            "April",
            "https://storage.googleapis.com/kancatani/predictedApril.png"))
        charts.add(ChartEntity(2 ,
            "Mei",
            "https://storage.googleapis.com/kancatani/PredictedMay.png"))
        return charts
    }
}