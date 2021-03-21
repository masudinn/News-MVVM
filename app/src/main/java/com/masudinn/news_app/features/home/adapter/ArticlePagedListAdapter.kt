package com.masudinn.news_app.features.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.masudinn.news_app.databinding.ItemNewsBinding
import com.masudinn.news_app.features.home.model.Articles

class ArticlesPagedListAdapter(val onClick: (Articles?) -> Unit): PagedListAdapter<Articles, ArticlesPagedListAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNewsBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = getItem(position)
        holder.apply {
            bind(article)
            itemView.setOnClickListener { onClick(article) }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Articles>() {
            override fun areContentsTheSame(oldItem: Articles, newItem: Articles): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areItemsTheSame(oldItem: Articles, newItem: Articles): Boolean {
                return oldItem == newItem
            }
        }
    }

    class ViewHolder(private val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(items: Articles?) {
            binding.apply {
                model = items
                executePendingBindings()
            }
        }

    }
}
