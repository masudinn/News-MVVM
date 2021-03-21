package com.masudinn.news_app.features.profile

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.masudinn.news_app.R
import com.masudinn.news_app.core.platform.BaseActivity
import com.masudinn.news_app.databinding.ActivityProfileBinding
import com.masudinn.news_app.features.home.view.WebViewActivity
import javax.inject.Inject

class ProfileActivity : BaseActivity<ActivityProfileBinding>(R.layout.activity_profile) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val viewModel: ProfileViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getProfile().observe(this, Observer {
            binding.profile = it
        })
    }

    fun goToDetail(url: String?, title: String?) {

        val i = Intent(this, WebViewActivity::class.java).apply {
            putExtra("url", url)
            putExtra("title", title)
        }
        startActivity(i)
    }
}
