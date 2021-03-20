package com.masudinn.news_app.core.Platform

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<VH: RecyclerView.ViewHolder, M> : RecyclerView.Adapter<VH>() {

    protected var models: List<M> = emptyList()

    open fun loadData(models: List<M>){
        this.models = models
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int = models.size

}