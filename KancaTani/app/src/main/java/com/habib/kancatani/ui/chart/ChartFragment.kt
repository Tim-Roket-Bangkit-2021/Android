package com.habib.kancatani.ui.chart

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.habib.kancatani.databinding.ChartFragmentBinding

class ChartFragment : Fragment() {

    private lateinit var fragmentChartBinding: ChartFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        fragmentChartBinding = ChartFragmentBinding.inflate(layoutInflater, container, false)
        return fragmentChartBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[ChartViewModel::class.java]
            val charts = viewModel.getCharts()

            val chartAdapter = ChartAdapter()
            chartAdapter.setCharts(charts)

            with(fragmentChartBinding.rvChart) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = chartAdapter
            }
        }
    }

}