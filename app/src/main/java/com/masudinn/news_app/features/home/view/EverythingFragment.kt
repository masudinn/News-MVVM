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
import com.masudinn.news_app.databinding.FragmentEverythingBinding


class EverythingFragment : BaseHomeFragment() {

    companion object {
        fun newInstance(): EverythingFragment {
            return EverythingFragment()
        }
    }

    private lateinit var binding: FragmentEverythingBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_everything, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@EverythingFragment.adapter
            setHasFixedSize(true)
        }

        viewModel.requestEverything()

        viewModel.getLoading().observe(this, Observer {
            if (it) LoadingDialog.show(activity) else LoadingDialog.dismiss()
        })

        viewModel.everything.observe(this, Observer {
            adapter.loadData(it)
        })
    }

}
