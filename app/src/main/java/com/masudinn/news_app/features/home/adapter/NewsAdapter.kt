package com.masudinn.news_app.features.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.masudinn.news_app.core.platform.BaseAdapter
import com.masudinn.news_app.databinding.ItemNewsBinding
import com.masudinn.news_app.features.home.model.Articles

class NewsAdapter(val onClick: (Articles) -> Unit): BaseAdapter<NewsAdapter.ViewHolder, Articles>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNewsBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = models[position]
        holder.apply {
            bind(article)
            itemView.setOnClickListener{onClick(article)}
        }
    }

    class ViewHolder(private val binding: ItemNewsBinding)
        : RecyclerView.ViewHolder(binding.root)  {
        fun bind(item: Articles){
            binding.apply {
                model = item
                executePendingBindings()
            }
        }
    }
}