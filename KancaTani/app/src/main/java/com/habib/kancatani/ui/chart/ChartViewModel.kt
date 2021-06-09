package com.habib.kancatani.ui.chart

import androidx.lifecycle.ViewModel
import com.habib.kancatani.data.ChartEntity
import com.habib.kancatani.utils.DataDummy

class ChartViewModel : ViewModel() {
    fun getCharts(): List<ChartEntity> = DataDummy.DummyChart()
}