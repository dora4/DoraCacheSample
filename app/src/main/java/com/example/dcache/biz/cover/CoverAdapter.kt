package com.example.dcache.biz.cover

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dcache.R

class CoverAdapter() : RecyclerView.Adapter<CoverAdapter.ViewHolder>() {

    private val covers = ArrayList<CoverModel>()
    private lateinit var listener: (pos: Int, model: CoverModel) -> Unit

    constructor(covers: ArrayList<CoverModel>) : this() {
        this.covers.addAll(covers)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_cover, parent,
                false))
    }

    fun addCovers(covers: ArrayList<CoverModel>) {
        covers.addAll(covers)
    }

    fun onItemClick(listener: (pos: Int, model: CoverModel) -> Unit) {
        this.listener = listener
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.findViewById<ImageView>(R.id.ivCoverIcon).setImageResource(covers[position].iconRes)
        holder.itemView.findViewById<TextView>(R.id.tvCoverTitle).text = covers[position].title
        holder.itemView.setOnClickListener {
            listener(position, covers[position])
        }
    }

    override fun getItemCount(): Int {
        return covers.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}