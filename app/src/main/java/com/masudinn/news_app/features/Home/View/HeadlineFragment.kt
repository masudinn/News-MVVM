package com.masudinn.news_app.features.Home.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.masudinn.news_app.R
import com.masudinn.news_app.core.Platform.BaseHomeFragment
import com.masudinn.news_app.core.Utils.LoadingDialog
import com.masudinn.news_app.databinding.FragmentHeadlineBinding

class HeadlineFragment : BaseHomeFragment() {

    companion object {
        fun newInstance(): HeadlineFragment {
            return HeadlineFragment()
        }
    }

    private lateinit var binding: FragmentHeadlineBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_headline, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@HeadlineFragment.adapter
            setHasFixedSize(true)
        }

        viewModel.requestHeadline()

        viewModel.getLoading().observe(this, Observer {
            if (it) LoadingDialog.show(activity) else LoadingDialog.dismiss()
        })

        viewModel.headline.observe(this, Observer {
            adapter.loadData(it)
        })
    }


}
