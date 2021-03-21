package com.masudinn.news_app.features.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.masudinn.news_app.core.platform.BaseAdapter
import com.masudinn.news_app.databinding.ItemListSourcesBinding
import com.masudinn.news_app.features.home.model.Sources

class SourceAdapter(val onClick: (Sources) -> Unit) :
BaseAdapter<SourceAdapter.ViewHolder, Sources>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListSourcesBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sources = models[position]
        holder.apply {
            bind(sources)
            itemView.setOnClickListener { onClick(sources) }
        }
    }


    class ViewHolder(private val binding: ItemListSourcesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Sources) {
            binding.apply {
                model = item
                executePendingBindings()
            }
        }
    }
}
