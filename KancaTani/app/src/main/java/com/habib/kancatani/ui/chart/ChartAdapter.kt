package com.habib.kancatani.ui.chart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.habib.kancatani.R
import com.habib.kancatani.data.ChartEntity
import com.habib.kancatani.databinding.ItemPrediksiBinding
import java.util.ArrayList

class ChartAdapter : RecyclerView.Adapter<ChartAdapter.ViewHolder>() {
    private var listCharts = ArrayList<ChartEntity>()

    fun setCharts(charts: List<ChartEntity>?) {
        if (charts == null) return
        this.listCharts.clear()
        this.listCharts.addAll(charts)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemsAcademyBinding = ItemPrediksiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemsAcademyBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val course = listCharts[position]
        holder.bind(course)
    }

    override fun getItemCount(): Int = listCharts.size


    class ViewHolder(private val binding: ItemPrediksiBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(course: ChartEntity) {
            with(binding) {
                binding.tvMonth.text = course.month
                Glide.with(itemView.context)
                    .load(course.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                    .into(imageView)
            }
        }
    }
}