package com.masudinn.news_app.features.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.masudinn.news_app.R
import com.masudinn.news_app.core.platform.BaseHomeFragment
import com.masudinn.news_app.core.Utils.LoadingDialog
import com.masudinn.news_app.databinding.FragmentSourceBinding
import com.masudinn.news_app.features.home.adapter.SourceAdapter


class SourceFragment : BaseHomeFragment() {

    companion object {
        fun newInstance(): SourceFragment {
            return SourceFragment()
        }
    }

    private lateinit var binding: FragmentSourceBinding

    private val sourcesAdapter: SourceAdapter by lazy {
        SourceAdapter{
            goToDetail(it.url, it.name)
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_source, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@SourceFragment.sourcesAdapter
            setHasFixedSize(true)
        }

        viewModel.requestSources()

        viewModel.getLoading().observe(this, Observer {
            if (it) LoadingDialog.show(activity) else LoadingDialog.dismiss()
        })

        viewModel.sources.observe(this, Observer {
            sourcesAdapter.loadData(it)
        })


    }


}
