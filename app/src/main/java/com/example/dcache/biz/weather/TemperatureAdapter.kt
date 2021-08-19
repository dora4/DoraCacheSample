package com.example.dcache.biz.weather

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dcache.R
import com.example.dcache.model.common.Temperature
import kotlin.collections.ArrayList

class TemperatureAdapter(private val temperatures: ArrayList<Temperature> = arrayListOf()) : RecyclerView.Adapter<TemperatureAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_temperature, null))
    }

    fun setTemperatures(temperatures: List<Temperature>) {
        this.temperatures.clear()
        this.temperatures.addAll(temperatures)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tvTemperatureDate = holder.itemView.findViewById<TextView>(R.id.tvTemperatureDate)
        val tvTemperatureAddr = holder.itemView.findViewById<TextView>(R.id.tvTemperatureAddr)
        val tvTemperatureMax = holder.itemView.findViewById<TextView>(R.id.tvTemperatureMax)
        val tvTemperatureMin = holder.itemView.findViewById<TextView>(R.id.tvTemperatureMin)
        tvTemperatureDate.text = temperatures[position].date!!.split("T")[0]
        tvTemperatureAddr.text = temperatures[position].addr
        tvTemperatureMax.text = "${temperatures[position].max}°"
        tvTemperatureMin.text = "${temperatures[position].min}°"
    }

    override fun getItemCount(): Int {
        return temperatures.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}