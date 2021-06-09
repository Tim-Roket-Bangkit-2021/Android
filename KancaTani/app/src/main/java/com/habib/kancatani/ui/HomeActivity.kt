package com.habib.kancatani.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.habib.kancatani.R
import com.habib.kancatani.databinding.ActivityHomeBinding
import com.habib.kancatani.ui.chart.ChartFragment
import kotlinx.android.synthetic.main.chart_fragment.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val chartFragment = ChartFragment()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.chart_container, chartFragment)
            .addToBackStack(null)
            .commit()
    }
}