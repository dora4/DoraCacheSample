package com.example.doracachesample.weather.biz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.doracachesample.R
import com.example.doracachesample.weather.common.Temperature
import kotlin.collections.ArrayList

class TemperatureAdapter(val temperatures: ArrayList<Temperature>) : RecyclerView.Adapter<TemperatureAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_temprature, null))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tvTemperatureDate = holder.itemView.findViewById<TextView>(R.id.tvTemperatureDate)
        val tvTemperatureMax = holder.itemView.findViewById<TextView>(R.id.tvTemperatureMax)
        val tvTemperatureMin = holder.itemView.findViewById<TextView>(R.id.tvTemperatureMin)
        tvTemperatureDate.text = temperatures[position].date!!.split("T")[0]
        tvTemperatureMax.text = "${temperatures[position].max}°"
        tvTemperatureMin.text = "${temperatures[position].min}°"
    }

    override fun getItemCount(): Int {
        return temperatures.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}